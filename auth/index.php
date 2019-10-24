<?php
require_once "../db/DBFunction.php";
require_once "../models/User.php";
require_once "../models/FieldValidator.php";
$db = new DBFunction();

    $uid = $_POST['uid'];
    $firstName = $_POST['first_name'];
    $middleName = $_POST['middle_name'];
    $lastName = $_POST['last_name'];
    $schoolNumber = $_POST["school_number"];
    $schoolClass = $_POST['school_class'];

    $user = new User($uid,$firstName, $middleName, $lastName, $schoolNumber, $schoolClass);
    $db->authUser($user);
    echo json_encode($user->getJsonData(), JSON_UNESCAPED_UNICODE);








?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Авторизация</title>
</head>
<body>
<form method="POST">
    <input type="text" name="uid" placeholder="uid"><br/>
    <input type="text" name="first_name" placeholder="Имя"><br/>
    <input type="text" name="last_name" placeholder="Фамилия"><br/>
    <input type="text" name="middle_name" placeholder="Отчество"><br/>
    <input type="text" name="school_number" placeholder="Номер школы"><br/>
    <input type="text" name="school_class" placeholder="Класс"><br/>
    <input type="submit" name="submit">
</form>
</body>
</html>