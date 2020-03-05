# Package Manager
App developed to support companies in order to managing applications and licencies.

## Technologies
* JavaEE + JSF and EJB as backend technologies
* Wildfly 18.0.1 on Mojarra as server
* PrimeFaces to generate view
* MySQL MariaDB as database engine

## Functionalities

### Accounts
Users cannot create accounts by themeselves. Only person with priviliges can create new account. It prevents before unauthorized app use.

### Roles and permissions
System admin can manage roles and permissions. Each role have name and description, also have own permission set. Permission set is list of permissions: `upload_file` `download_file` `delete_file` `create_package` `delete_package` `set_permission` `create_user` `view_logs` `get_licence` `add_licence` where permission value is defined by true or false. The default role on system first run is sysadmin who have all priviliges. System allows to create roles with different permissions.

### User management
User with priviliges can create and manage users. Application provides to change details like login, mail, name surname, password and role.

### Logs
Each action is recorded and saved in database. If someone will try broke someone password, admin will see it in logs as security breach. Actions like user account delete/file delete/role edit/delite will be shown on Logs subpage.

### File upload
Application provides to upload files into database with name, description and version. User is able to show list of files, search into files and download single file. User with additional privileges can delete files from system.

### Package management
We can group files into package. Users with privileges can download and manage their packages.

### Dashboard and statistics
Simple dashboard with statistics: how many users, files, packages do we have in our system and also linear chart with download history grouped by month.



