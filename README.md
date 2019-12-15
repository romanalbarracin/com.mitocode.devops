# Instrucciones para ejecutar el proyecto

1. Ejecutar el archivo docker-compose de la carpeta src/devops:
```
docker-compose -f docker-compose-servers-devops up -d
```
2. Obteener clave de administrador jenkins:
```
docker-compose -f dock er-compose-servers-devops exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
```
3. En jenkins:
	- Instalar los plugins sugeridos
	- Crear usuario y clave 'admin'
	- Dejar url por defecto
	- Actualizar plugins
	- instalar pluglin 'docker'
	- instalar el plugin 'pipeline-utility-steps'

4. Crear Job en Jenkins de tipo **Multibranch Pipeline**

5. Connectar repositorio git del proyecto java de ejemplo con la ruta
```
git@github.com:romanalbarracin/java_devops_mitocode.git
```
6. Configurar las credenciales con el repositorio SSH con la llave privada proporcionada (archivo enviado por correo)

7. Programar ejecucion del job de jenkins cada minuto


