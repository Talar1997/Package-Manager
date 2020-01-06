# Package Manager
App developed to support companies in order to managing applications and licencies.

## Technology
* JavaEE + JSF and EJB as backend technologies
* Wildfly 18.0.1 on Mojarra as server
* PrimeFaces to generate view
* MySQL MariaDB as database engine

## Functionalities

### Accounts
Users cannot create accounts by themeselves. Only person with priviliges can create new account. It prevents before unauthorized app use.

### Roles and permissions
System admin can manage roles and permissions. Each role have name and description, also have own permission set. Permission set is list of permissions: `upload_file` `download_file` `delete_file` `create_package` `delete_package` `set_permission` `create_user` `view_logs` `get_licence` `add_licence` where permission value is defined by true or false. The default role on system first run is sysadmin who have all priviliges. System allows to create roles with different permissions.

### Internationalization
 
### License managment

### Apps and packages managment
