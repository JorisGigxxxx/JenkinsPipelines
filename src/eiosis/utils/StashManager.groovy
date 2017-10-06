#!/usr/bin/groovy
package eiosis.utils

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

