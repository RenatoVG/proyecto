<?php
class Conexion{
    public function conectar()
    {
        $pdo = null;
        try {
            $pdo = new PDO('mysql:host='.DB_HOST.';dbname='.DB_NAME.'', DB_USER, DB_PASS);
            return $pdo;
        } catch (PDOException $e) {
            print "¡Error!: " . $e->getMessage() . "<br/>";
            die();
        }
    }
}
$conexion=mysqli_connect("sql308.infinityfree.com","if0_34786215","p23983321","if0_34786215_venta") or die ("Error");
?>