pipeline
{
    agent any
    // This displays colors using the 'xterm' ansi color map.
    stages
    {
        stage ('Pre build Stage')
        {
            steps
            {
                echo "Start Pre Build for revision: ${env.HG_REVISION}"
                echo "End   Pre Build"
            }
        }

        stage ('Build Stage')
        {
            steps
            {
                echo "Start Build"
                echo "End   Build"
                error "error simulation"
                post
                {
                    success
                    {
                        echo "Build Succeed"
                    }
                    failure
                    {
                        echo "Build Failed"
                    }
                }
            }
        }

        stage ('Post Build Stage')
        {
            steps
            {
                echo "Start Post Build"
                echo "End   Post Build"
            }
        }
    }
}
