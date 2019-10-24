<?php
    // db connect layer
    require_once "config.php";
    session_start();
    class DBConnection
    {
        private $db;
        private $uid;

        public function connect()
        {
            $this->db = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
            $this->uid = $_SESSION["uid"];
            return $this->db;
        }
        public function getUid()
        {
            return $this->uid;
        }
    }