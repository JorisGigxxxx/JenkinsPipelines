#!/usr/bin/groovy
package eiosis.utils

class StashManager
{
    StashManager(inSteps)
    {
        this.mSteps = inSteps
        mSteps.echo "StageManager constructor"
    }

// ----------------------------------------------------------------------------

    def addArtifact(String inName, String inPath)
    {
        if (this.mArtifacts.contains(inName))
        {
            mSteps.echo "Cannot duplicate stash entries"
            return
        }
        mSteps.echo "Stash mArtifacts:" + inPath + " as entry: " + inName
        mArtifacts << inName
        mSteps.stash includes: inPath, name: inName
    }

    def dump()
    {
        mSteps.echo mArtifacts
    }

    def unstash()
    {
        mArtifacts.each
        { item ->
            mSteps.unstash name:item
        }
    }

// ----------------------------------------------------------------------------

    private mSteps
    private Set<String> mArtifacts = []
}

