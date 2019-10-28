<?php
require_once "../../db/DBFunction.php";
require_once "../../models/User.php";

$db = new DBFunction();

$uid = $_POST['uid'];
$firstName = $_POST['first_name'];
$middleName = $_POST['middle_name'];
$lastName = $_POST['last_name'];
$schoolNumber = $_POST["school_number"];
$schoolClass = $_POST['school_class'];

$user = new User($uid,$firstName, $middleName, $lastName, $schoolNumber, $schoolClass);
if($db->authUser($user))
{
    echo json_encode($user->getJsonData(), JSON_UNESCAPED_UNICODE);
}