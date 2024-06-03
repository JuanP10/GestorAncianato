<h1>Gestor de Donaciones para Asilos (Backend)</h1>

<p>Este proyecto backend forma parte de un sistema de gestión de donaciones para asilos, diseñado para organizar y administrar eficientemente las donaciones de medicamentos, insumos y otros recursos para el cuidado de adultos mayores en un entorno de asilo. El objetivo principal es evitar la pérdida y el vencimiento de los medicamentos mediante un sistema de gestión centralizado.</p>
<br>
<h2>Caracteristicas Principales</h2>
<ul>
  <li><strong>Organización de Donaciones:</strong> Proporciona una estructura organizada para almacenar y gestionar medicamentos, categorizándolos según su tipo y fecha de vencimiento.</li>
  <li><strong>Gestión de Inventario:</strong> Permite llevar un seguimiento detallado del inventario de medicamentos y otros insumos, evitando la duplicación y asegurando que los recursos estén disponibles cuando se necesiten.</li>
  <li><strong>Integración de Donantes: </strong> Registra y administra la información de los donantes, garantizando que cada donación esté asociada a un donante registrado en el sistema.</li>
</ul>
<br>

<h2>Tecnologías utilizadas</h2>
<ol>
  <li>Javas</li>
  <li>Spring Boot</li>
  <li>Docker</li>
  <li>MapStruct</li>
  <li>Swagger</li>
  <li>JPA</li>
  <li>Lombok</li>
  <li>MySQL</li>
</ol>

<br>
<h2>Entidades</h2>
<ul>
  <li><strong>Donante:</strong> Representa a una persona u organización que realiza una donación. Cada donante está asociado con una o más donaciones de medicamento realizadas al asilo.</li>
  <li><strong>Medicamento:</strong> Representa un medicamento donado, incluyendo información como el nombre, la cantidad disponible y la fecha de vencimiento. Los medicamentos están categorizados según su tipo y puede estar relacionado con uno a más Categorias.</li>
  <li><strong>Categoria Medicamento: </strong> Define las categorías a las que pueden pertenecer los medicamentos, como analgésicos, antibióticos, etc...</li>
  <li><strong>Enfermero: </strong> Representa al personal médico encargado de administrar y gestionar los recursos médicos en el asilo. Puede tener el Rol de Jefe o Auxiliar</li>
  <li><strong>Adulto Mayor: </strong> Representa a los residentes del asilo, incluyendo información sobre su estado de salud y condiciones médicas (Puede ser una o más)</li>
  <li><strong>Condición Medica: </strong> Define las condiciones médicas que pueden afectar a los adultos mayores, como diabetes, hipertensión, etc...</li>
  <li><strong>Insumo: </strong> Representa el insumo del medicamento realizado por parte de un enfermero al adulto Mayor</li>
</ul>

<br>
<h2>Atributos y Endpoints del Donante</h2>
<table>
  <tr>
    <th>Nombre del Atributo</th>
    <th>Tipo de Dato</th>
    <th>Descripción</th>
  </tr>
  <tr>
    <td>cedula</td>
    <td>Long</td>
    <td>Identificación única del donante</td>
  </tr>
  <tr>
    <td>nombre</td>
    <td>String</td>
    <td>Nombre del donante</td>
  </tr>
  <tr>
    <td>apellido</td>
    <td>String</td>
    <td>Apellido del donante</td>
  </tr>
  <tr>
    <td>telefono</td>
    <td>Long</td>
    <td>Número de teléfono del donante</td>
  </tr>
  <tr>
    <td>direccion</td>
    <td>String</td>
    <td>Dirección del donante</td>
  </tr>
</table>

<ul>
  <li>
    <strong>Registrar Donante:</strong> POST /Donante
    <br>Endpoint para registrar un nuevo donante.
  </li>
  <li>
    <strong>Actualizar Donante:</strong> PUT /Donante/{cedula}
    <br>Endpoint para actualizar los datos de un donante existente.
  </li>
  <li>
    <strong>Eliminar Donante:</strong> DELETE /Donante/{cedula}
    <br>Endpoint para eliminar un donante por su cédula.
  </li>
  <li>
    <strong>Obtener Donante por Cédula:</strong> GET /Donante/{cedula}
    <br>Endpoint para obtener información de un donante por su cédula.
  </li>
  <li>
    <strong>Obtener Donantes por Nombre y Apellido:</strong> GET /Donante/nombre&apellido?nombre={nombre}&apellido={apellido}
    <br>Endpoint para buscar donantes por nombre y apellido.
  </li>
  <li>
    <strong>Obtener Todos los Donantes:</strong> GET /Donante/all
    <br>Endpoint para obtener todos los donantes registrados.
  </li>
</ul>
<br>
<h2>Atributos y Endpoints del Medicamento</h2>
<table>
  <tr>
    <th>Nombre del Atributo</th>
    <th>Tipo de Dato</th>
    <th>Descripción</th>
  </tr>
  <tr>
    <td>id</td>
    <td>Long</td>
    <td>Identificador único del medicamento</td>
  </tr>
  <tr>
    <td>nombre</td>
    <td>String</td>
    <td>Nombre del medicamento</td>
  </tr>
  <tr>
    <td>cantidad</td>
    <td>int</td>
    <td>Cantidad disponible del medicamento</td>
  </tr>
  <tr>
    <td>fechaVencimiento</td>
    <td>LocalDate</td>
    <td>Fecha de vencimiento del medicamento</td>
  </tr>
  <tr>
    <td>donante</td>
    <td>Donante</td>
    <td>Donante que realizó la donación del medicamento</td>
  </tr>
  <tr>
    <td>categoriaMedicamento</td>
    <td>Set&lt;CategoriaMedicamento&gt;</td>
    <td>Categorías a las que pertenece el medicamento</td>
  </tr>
</table>

<ul>
  <li>
    <strong>Crear Medicamento:</strong> POST /Medicamento
    <br>Endpoint para registrar un nuevo medicamento.
  </li>
  <li>
    <strong>Actualizar Medicamento:</strong> PUT /Medicamento/{id}
    <br>Endpoint para actualizar los datos de un medicamento existente.
  </li>
  <li>
    <strong>Eliminar Medicamento:</strong> DELETE /Medicamento/{id}
    <br>Endpoint para eliminar un medicamento por su ID.
  </li>
  <li>
    <strong>Obtener Medicamento por ID:</strong> GET /Medicamento/{id}
    <br>Endpoint para obtener información de un medicamento por su ID.
  </li>
  <li>
    <strong>Obtener Todos los Medicamentos:</strong> GET /Medicamento/all
    <br>Endpoint para obtener todos los medicamentos registrados.
  </li>
  <li>
    <strong>Obtener Medicamentos por Categorías:</strong> GET /Medicamento/catMedicamentos?catMedicamentos={catMedicamentos}
    <br>Endpoint para obtener medicamentos por categorías.
  </li>
  <li>
    <strong>Obtener Medicamentos por Cédula del Donante:</strong> GET /Medicamento/donanteCedula?cedula={cedula}
    <br>Endpoint para obtener medicamentos por la cédula del donante.
  </li>
  <li>
    <strong>Obtener Medicamentos por Fecha de Vencimiento:</strong> GET /Medicamento/fechaVencimiento?mes={mes}&año={año}
    <br>Endpoint para obtener medicamentos por mes y año de vencimiento.
  </li>
</ul>
<br>
<h2>Atributos y Endpoints de Categoria Medicamento</h2>
<table>
  <tr>
    <th>Nombre del Atributo</th>
    <th>Tipo de Dato</th>
    <th>Descripción</th>
  </tr>
  <tr>
    <td>id</td>
    <td>Long</td>
    <td>Identificador único de la categoría de medicamento</td>
  </tr>
  <tr>
    <td>nombreCat</td>
    <td>String</td>
    <td>Nombre de la categoría de medicamento</td>
  </tr>
  <tr>
    <td>medicamentos</td>
    <td>Set&lt;Medicamento&gt;</td>
    <td>Conjunto de medicamentos asociados a esta categoría</td>
  </tr>
</table>
<ul>
  <li>
    <strong>Crear Categoría:</strong> POST /Categoria
    <br>Endpoint para registrar una nueva categoría de medicamento.
  </li>
  <li>
    <strong>Actualizar Categoría:</strong> PUT /Categoria/{id}
    <br>Endpoint para actualizar los datos de una categoría de medicamento existente.
  </li>
  <li>
    <strong>Eliminar Categoría:</strong> DELETE /Categoria/{id}
    <br>Endpoint para eliminar una categoría de medicamento por su ID.
  </li>
  <li>
    <strong>Obtener Categoría por ID:</strong> GET /Categoria/{id}
    <br>Endpoint para obtener información de una categoría de medicamento por su ID.
  </li>
  <li>
    <strong>Obtener Todas las Categorías:</strong> GET /Categoria/all
    <br>Endpoint para obtener todas las categorías de medicamento registradas.
  </li>
</ul>
<br>
<h2>Atributos y Endpoints del Enfermero</h2>
<table>
  <tr>
    <th>Nombre del Atributo</th>
    <th>Tipo de Dato</th>
    <th>Descripción</th>
  </tr>
  <tr>
    <td>cedula</td>
    <td>Long</td>
    <td>Identificador único del enfermero</td>
  </tr>
  <tr>
    <td>nombre</td>
    <td>String</td>
    <td>Nombre del enfermero</td>
  </tr>
  <tr>
    <td>apellido</td>
    <td>String</td>
    <td>Apellido del enfermero</td>
  </tr>
  <tr>
    <td>rol</td>
    <td>Rol</td>
    <td>Rol del enfermero (JEFE o AUXILIAR)</td>
  </tr>
  <tr>
    <td>contrasena</td>
    <td>String</td>
    <td>Contraseña del enfermero</td>
  </tr>
  <tr>
    <td>suministros</td>
    <td>List&lt;Suministro&gt;</td>
    <td>Lista de los suministros realizados al enfermero</td>
  </tr>
</table>
<ul>
  <li>
    <strong>Crear Enfermero:</strong> POST /Enfermero
    <br>Endpoint para registrar un nuevo enfermero.
  </li>
  <li>
    <strong>Obtener Todos los Enfermeros:</strong> GET /Enfermero/all
    <br>Endpoint para obtener todos los enfermeros registrados.
  </li>
  <li>
    <strong>Obtener Enfermero por Cedula:</strong> GET /Enfermero/{cedula}
    <br>Endpoint para obtener información de un enfermero por su cédula.
  </li>
  <li>
    <strong>Actualizar Enfermero:</strong> PUT /Enfermero/{cedula}
    <br>Endpoint para actualizar los datos de un enfermero existente.
  </li>
  <li>
    <strong>Eliminar Enfermero:</strong> DELETE /Enfermero/{cedula}
    <br>Endpoint para eliminar un enfermero por su cédula.
  </li>
  <li>
    <strong>Obtener Enfermero por Nombre y Apellido:</strong> GET /Enfermero/nombre&apellido?nombre={nombre}&apellido={apellido}
    <br>Endpoint para obtener información de un enfermero por su nombre y apellido.
  </li>
</ul>
<br>
<h2>Atributos y Endpoints del AdultoMayor</h2>
<table>
  <tr>
    <th>Nombre del Atributo</th>
    <th>Tipo de Dato</th>
    <th>Descripción</th>
  </tr>
  <tr>
    <td>cedula</td>
    <td>Long</td>
    <td>Identificador único del adulto mayor</td>
  </tr>
  <tr>
    <td>nombre</td>
    <td>String</td>
    <td>Nombre del adulto mayor</td>
  </tr>
  <tr>
    <td>apellido</td>
    <td>String</td>
    <td>Apellido del adulto mayor</td>
  </tr>
  <tr>
    <td>fechaNacimiento</td>
    <td>LocalDate</td>
    <td>Fecha de nacimiento del adulto mayor</td>
  </tr>
  <tr>
    <td>esPensionado</td>
    <td>Boolean</td>
    <td>Indica si el adulto mayor es pensionado</td>
  </tr>
  <tr>
    <td>suministros</td>
    <td>Set&lt;Suministro&gt;</td>
    <td>Conjunto de suministros asociados al adulto mayor</td>
  </tr>
  <tr>
    <td>condicionesMedicas</td>
    <td>Set&lt;CondicionMedica&gt;</td>
    <td>Conjunto de condiciones médicas del adulto mayor</td>
  </tr>
</table>
<ul>
  <li>
    <strong>Crear Adulto Mayor:</strong> POST /AdultoMayor
    <br>Endpoint para registrar un nuevo adulto mayor.
  </li>
  <li>
    <strong>Obtener Todos los Adultos Mayores:</strong> GET /AdultoMayor/all
    <br>Endpoint para obtener todos los adultos mayores registrados.
  </li>
  <li>
    <strong>Actualizar Adulto Mayor:</strong> PUT /AdultoMayor/{cedula}
    <br>Endpoint para actualizar los datos de un adulto mayor existente.
  </li>
  <li>
    <strong>Eliminar Adulto Mayor:</strong> DELETE /AdultoMayor/{cedula}
    <br>Endpoint para eliminar un adulto mayor por su cédula.
  </li>
  <li>
    <strong>Obtener Adulto Mayor por Cédula:</strong> GET /AdultoMayor/{cedula}
    <br>Endpoint para obtener información de un adulto mayor por su cédula.
  </li>
  <li>
    <strong>Obtener Adulto Mayor por Nombre y Apellido:</strong> GET /AdultoMayor/nombre&apellido?nombre={nombre}&apellido={apellido}
    <br>Endpoint para obtener información de un adulto mayor por su nombre y apellido.
  </li>
  <li>
    <strong>Buscar Adultos Mayores por Condición Médica:</strong> GET /AdultoMayor/{CondicionMedica}
    <br>Endpoint para buscar adultos mayores por una condición médica específica.
  </li>
</ul>
<br>
<h2>Atributos y Endpoints de Condicion Medica</h2>
<table>
  <tr>
    <th>Nombre del Atributo</th>
    <th>Tipo de Dato</th>
    <th>Descripción</th>
  </tr>
  <tr>
    <td>id</td>
    <td>Long</td>
    <td>Identificador único de la condición médica</td>
  </tr>
  <tr>
    <td>nombre</td>
    <td>String</td>
    <td>Nombre de la condición médica</td>
  </tr>
  <tr>
    <td>adultosMayores</td>
    <td>Set&lt;AdultoMayor&gt;</td>
    <td>Conjunto de adultos mayores asociados a esta condición médica</td>
  </tr>
</table>
<ul>
  <li>
    <strong>Crear Condición Médica:</strong> POST /condicion
    <br>Endpoint para registrar una nueva condición médica.
  </li>
  <li>
    <strong>Actualizar Condición Médica:</strong> PUT /condicion/{id}
    <br>Endpoint para actualizar los datos de una condición médica existente.
  </li>
  <li>
    <strong>Eliminar Condición Médica:</strong> DELETE /condicion/{id}
    <br>Endpoint para eliminar una condición médica por su ID.
  </li>
  <li>
    <strong>Obtener Todas las Condiciones Médicas:</strong> GET /condicion/all
    <br>Endpoint para obtener todas las condiciones médicas registradas.
  </li>
  <li>
    <strong>Obtener Condición Médica por ID:</strong> GET /condicion/{id}
    <br>Endpoint para obtener información de una condición médica por su ID.
  </li>
  <li>
    <strong>Obtener Condición Médica por Nombre:</strong> GET /condicion/nombre/{nombre}
    <br>Endpoint para obtener información de una condición médica por su nombre.
  </li>
</ul>
<br>
<h2>Atributos y Endpoints del Suministro</h2>
<table>
  <tr>
    <th>Nombre del Atributo</th>
    <th>Tipo de Dato</th>
    <th>Descripción</th>
  </tr>
  <tr>
    <td>id</td>
    <td>Long</td>
    <td>Identificador único del suministro</td>
  </tr>
  <tr>
    <td>cantidad</td>
    <td>int</td>
    <td>Cantidad suministrada</td>
  </tr>
  <tr>
    <td>fechaSuministro</td>
    <td>LocalDate</td>
    <td>Fecha del suministro</td>
  </tr>
  <tr>
    <td>medicamento</td>
    <td>Medicamento</td>
    <td>Medicamento suministrado</td>
  </tr>
  <tr>
    <td>adultoMayor</td>
    <td>AdultoMayor</td>
    <td>Adulto mayor al que se le suministra el medicamento</td>
  </tr>
  <tr>
    <td>enfermero</td>
    <td>Enfermero</td>
    <td>Enfermero que realiza el suministro</td>
  </tr>
</table>
<ul>
  <li>
    <strong>Crear Suministro:</strong> POST /Suministro
    <br>Endpoint para registrar un nuevo suministro.
  </li>
  <li>
    <strong>Actualizar Suministro:</strong> PUT /Suministro/{id}
    <br>Endpoint para actualizar los datos de un suministro existente.
  </li>
  <li>
    <strong>Eliminar Suministro:</strong> DELETE /Suministro/{id}
    <br>Endpoint para eliminar un suministro por su ID.
  </li>
  <li>
    <strong>Obtener Todos los Suministros:</strong> GET /Suministro/all
    <br>Endpoint para obtener todos los suministros registrados.
  </li>
  <li>
    <strong>Obtener Suministro por ID:</strong> GET /Suministro/{id}
    <br>Endpoint para obtener información de un suministro por su ID.
  </li>
  <li>
    <strong>Obtener Suministros por Fecha:</strong> GET /Suministro/fecha/{fechaInicio}/{fechaFin}
    <br>Endpoint para obtener los suministros realizados en un rango de fechas.
  </li>
  <li>
    <strong>Obtener Suministros por Medicamento:</strong> GET /Suministro/medicamento/{medicamento}
    <br>Endpoint para obtener los suministros de un medicamento específico.
  </li>
  <li>
    <strong>Obtener Suministros por Adulto Mayor:</strong> GET /Suministro/adultoMayor/{cedula}
    <br>Endpoint para obtener los suministros realizados a un adulto mayor específico.
  </li>
</ul>

<br>



<h2>Instalación y Uso</h2>
<p>Clona este repositorio en tu máquina local.</p>
<p>Asegúrate de tener Docker instalado y en ejecución.</p>
<p>Desde la raíz del proyecto, ejecuta el comando <code>docker-compose up</code> para construir y ejecutar la aplicación en un contenedor Docker.</p>
<p>La aplicación estará disponible en <a href="http://localhost:8080">http://localhost:8080</a>.</p>
<br>
<br>

<strong>Repositorio del FrontEnd: PROXIMAMENTE</strong>
</html>
