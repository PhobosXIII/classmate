<?php

class ResponseMessage
{
    private $code;
    private $message;
    private $flag;

    public static function sendMessage($code, $message)
    {
        $response = array("code"=>$code, "message"=>$message);
        echo json_encode($response);
    }
}