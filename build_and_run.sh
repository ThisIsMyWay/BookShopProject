#!/bin/bash

buildApplication() {
    echo "############################################ BUILDING APPLICATION ########################################################"
    cd BackendEE 
    mvn clean install -T 2
    cd ..
}

runDockerContainersWithLogs() {
    echo "############################################ STARTING DOCKER CONTAINERS ###################################################"
    cd docker/dev
    docker-compose up
    cd ../..
}

buildAndRunDockerContainersDetached() {
    echo "############################################ REBUILDING AND STARTING DOCKER CONTAINERS DETACHED ############################"
    cd docker/dev
    docker-compose up --force-recreate --build --detach
    cd ../..
}

waitTillContainersAreReady() {
    echo "############################################ PREPARING FOR INTEGRATION TESTS ################################################"
    until docker inspect -f '{{.State.Health.Status}}' dev_wildfly_1 2>/dev/null | grep -q 'healthy';
    do 
        echo "waiting till all containers are runing..."
        sleep 1s
    done
}

runIntegrationTests() {
    echo "############################################ LAUNCHING INTEGRATION TESTS ####################################################"
    cd BackendEE 
    mvn failsafe:integration-test failsafe:verify
    cd ..    
}

tearDownContainers() {
    echo "############################################ TEAR DOWN CONTAINERS ############################################################"
    cd docker/dev
    docker-compose down
    cd ../..
}

messageForInvalidParameters() {
    echo -e "You provided invalid arguments.\n"
    echo -e $help_message
}

runApplicationInParticularMode() {
    if [ "$1" = "dev" ]; then 
        buildApplication
        runDockerContainersWithLogs
    elif [ "$1" = "test" ]; then 
        buildApplication
        buildAndRunDockerContainersDetached
        waitTillContainersAreReady
        runIntegrationTests
        tearDownContainers
    else 
        messageForInvalidParameters
    fi
}

runActionDependentOnArguments() {
    if [ "$1" = "-mode" ]; then 
         runApplicationInParticularMode $2
    elif [ "$1" = "-help" ] || [ "$1" = "-h" ]; then
        echo -e "Printing help message.\n"
        echo -e $help_message
    else 
        messageForInvalidParameters 
    fi
}

help_message='Available arguments are:\n
    \t-mode <choosen mode>        Run application in chosen mode\n
    \t\tAvailable modes are:\n
    \t\tdev = build application and start up containers with builded app deployed\n
    \t\ttest = build application, start up containers with builded app deployed, then runs integration tests and close containers\n
    \t\tFor example to start application in test mode you should run script in this way: sh build_and_run.sh -mode test\n
    \t-help or -h                 Print this help message'


if [ $# -eq 0 ];
then
    echo "You haven't passed any argument, so the application will be run in dev mode.\n"
    echo -e $help_message
    buildApplication
    runDockerContainersWithLogs    
else
    runActionDependentOnArguments $1 $2
fi
