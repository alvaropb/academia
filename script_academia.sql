-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: academia
-- ------------------------------------------------------
-- Server version	5.7.31-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `academia`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `academia` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `academia`;

--
-- Table structure for table `alumnosCurso`
--

DROP TABLE IF EXISTS `alumnosCurso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumnosCurso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idAlumno` int(11) NOT NULL,
  `idCurso` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idCurso` (`idCurso`),
  KEY `FK_alumnosCurso_usuarios` (`idAlumno`),
  CONSTRAINT `FK_alumnosCurso_usuarios` FOREIGN KEY (`idAlumno`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `alumnosCurso_ibfk_2` FOREIGN KEY (`idCurso`) REFERENCES `cursos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnosCurso`
--

LOCK TABLES `alumnosCurso` WRITE;
/*!40000 ALTER TABLE `alumnosCurso` DISABLE KEYS */;
INSERT INTO `alumnosCurso` VALUES (1,4,1),(2,4,2),(3,5,1),(4,5,3),(5,6,2),(6,6,3),(7,7,1),(8,7,3);
/*!40000 ALTER TABLE `alumnosCurso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cursos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `curso` varchar(100) NOT NULL DEFAULT 'N/A',
  `identificador` varchar(10) NOT NULL DEFAULT 'N/A',
  `horas` int(11) NOT NULL DEFAULT '0',
  `idProfesor` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cursos_UN` (`identificador`),
  KEY `FK_cursos_profesores` (`idProfesor`),
  CONSTRAINT `FK_cursos_profesores` FOREIGN KEY (`idProfesor`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (1,'Microsoft Office 2016','I001',50,1),(2,'Experto en Desarrollo de Aplicaciones WEB y Bases de Datos','I002',630,2),(3,'Desarrollo Avanzado con JAVA/JEE','I003',510,3);
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reseinas`
--

DROP TABLE IF EXISTS `reseinas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reseinas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reseina` text,
  `idAlumno` int(11) NOT NULL,
  `idCurso` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idCurso` (`idCurso`),
  KEY `FK_reseinas_usuario_alumno` (`idAlumno`),
  CONSTRAINT `FK_reseinas_usuario_alumno` FOREIGN KEY (`idAlumno`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `reseinas_ibfk_1` FOREIGN KEY (`idCurso`) REFERENCES `cursos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reseinas`
--

LOCK TABLES `reseinas` WRITE;
/*!40000 ALTER TABLE `reseinas` DISABLE KEYS */;
/*!40000 ALTER TABLE `reseinas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `rol` int(11) NOT NULL DEFAULT '1' COMMENT 'rol:1 alumno 2 profesor',
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuarios_UN` (`nombre`,`apellidos`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Alain','Moles',2,'e10adc3949ba59abbe56e057f20f883e'),(2,'Ander','Uraga',2,'e10adc3949ba59abbe56e057f20f883e'),(3,'Pepito','Piscinas',2,'e10adc3949ba59abbe56e057f20f883e'),(4,'Elier','Otero',1,'e10adc3949ba59abbe56e057f20f883e'),(5,'Beatriz','Martinez',1,'e10adc3949ba59abbe56e057f20f883e'),(6,'Asier','Mintegui',1,'e10adc3949ba59abbe56e057f20f883e'),(7,'Lander','Bilbao',1,'e10adc3949ba59abbe56e057f20f883e');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-15 11:51:24
