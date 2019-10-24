<?php

class ResponseMessage
{
    private $code;
    private $message;
    private $flag;
    public static  $FLAG_SUCCESS = 0;
    public static $FLAG_ERROR = 1;
    public function sendMessage($code, $message, $flag)
    {
        if($flag== self::$FLAG_SUCCESS) {
            $this->message = array("code" => $code, "message" => $message);
            return json_encode($this->message);
        }
        else
        {
            $this->message = array("code" => $code, "message" => $message);
            return json_encode($this->message);
        }
    }
}