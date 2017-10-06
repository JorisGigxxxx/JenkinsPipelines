#!/usr/bin/groovy
package eiosis.utils

def call(body)
{
    try
    {
        stage ('Clone')
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

class StashManager
{
    StashManager()
    {
        echo "StageManager constructor"
    }

// ----------------------------------------------------------------------------

    def addArtifact(String inName, String inPath)
    {
        if (this.mArtifacts.contains(inName))
        {
            echo "Cannot duplicate stash entries"
            return
        }
        echo "Stash mArtifacts:" + inPath + " as entry: " + inName
        mArtifacts << inName
        stash includes: inPath, name: inName
    }

    def dump()
    {
        echo mArtifacts
    }

    def unstash()
    {
        mArtifacts.each
        { item ->
            unstash name:item
        }
    }

// ----------------------------------------------------------------------------

    private Set<String> mArtifacts = []
}

