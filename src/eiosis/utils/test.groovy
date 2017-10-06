#!/usr/bin/groovy
package eiosis.utils

def call(body)
{
    try
    {
        Stage ('Clone')
        {
        }
        stage ('Build')
        {
        }
        stage ('Tests')
        {
            parallel 'static':
            {
                sh "echo 'shell scripts to run static tests...'"
            },
            'unit':
            {
                sh "echo 'shell scripts to run unit tests...'"
            },
            'integration':
            {
                sh "echo 'shell scripts to run integration tests...'"
            }
        }
        stage ('Deploy')
        {
        }
    }
    catch (err)
    {
        currentBuild.result = 'FAILED'
        throw err
    }
}

