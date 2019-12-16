# Instrucciones para ejecutar el proyecto



1. Ejecutar el archivo docker-compose de la carpeta src/devops:
```
docker-compose -f docker-compose-servers-devops up -d
```
_Nota: El servicio de tomcat a veces no inicia y debo hacerlo con el comando: docker run -d -it --rm -p 8888:8080 tomcat:8.0-alpine_ 

2. Obtener clave de administrador jenkins e ingresarla:
```
docker-compose -f dock er-compose-servers-devops exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
```
3. En jenkins:
	- Instalar los plugins sugeridos inicialmente
	- Crear usuario y clave 'admin'
	- Dejar url por defecto
	- Actualizar plugins
	- Instalar pluglin 'docker'
	- Instalar el plugin 'pipeline-utility-steps'

4. Crear Job en Jenkins con el nombre ***java_devops_mitocode** y de tipo **Multibranch Pipeline**

5. Conectar repositorio git del proyecto java de ejemplo con la ruta
```
git@github.com:romanalbarracin/com.mitocode.devops.git
```
6. Configurar las credenciales con el repositorio SSH con la llave privada proporcionada (archivo enviado por correo)

7. Programar ejecución del job de jenkins cada minuto

8. Para el deploy del war instalar el plugin **Deploy to container** y crear un job jenkins de tipo **Multibranch Pipeline** y alli crear la configuracion para desplegar en el servicio de tomcat:

	- Conectar al repositorio del proyecto
	- Configurar el **build** con maven y con Goals _clean install_
	- Configurar el **post-deploy** con _Deploy war/ear to a container_ con los valores
	  - WAR/EAR files: /var/jenkins_home/workspace/com.mitocode.devops/target/devops.war
	  - Context path: devops
	  - Containers/ Tomact URL: http://localhost:8888


Con estos pasos deberia funcionar correctamente.


