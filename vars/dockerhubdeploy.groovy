def call(){
      echo "This is building the TesT case"
                  withCredentials([usernamePassword('credentialsId':"DockerhubCred",
                  passwordVariable:"dockerHubpass",usernameVariable:"dockerhubuser")]){
                  sh "docker login -u ${env.dockerhubuser} -p ${env.dockerHubpass}"
                  sh "docker  image tag notes-app:latest ${env.dockerhubuser}/notes-app:latest"
                  sh "docker push ${env.dockerhubuser}/notes-app:latest"}
}
