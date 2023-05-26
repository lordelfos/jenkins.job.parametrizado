job('ejemplo3-job-DSL') {
	description('Job DSL de ejemplo para el curso de Jenkins')
  	scm {
      		git('https://github.com/macloujulian/jenkins.job.parametrizado.git', 'main') { node ->
        		node / gitConfigName('lordelfos')
        		node / gitConfigEmail('lordelfos@gmail.com')
      		}
    	} 
  	parameters {
   		stringParam('nombre', defaultValue = 'Julian', description = 'Parametro de cadena para el Job Booleano')
      		choiceParam('planeta', ['Mercurio', 'Venus', 'Tierrra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
      		booleanParam('agente', false)
    	}
  	triggers {
    		cron('H/7 * * * *')
        	githubPush()
    	}
  	steps {
    		shell("bash jobscript.sh")
    	}

}