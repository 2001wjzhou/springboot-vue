-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: cxjw
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Temporary view structure for view `view_course_dept`
--

DROP TABLE IF EXISTS `view_course_dept`;
/*!50001 DROP VIEW IF EXISTS `view_course_dept`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_course_dept` AS SELECT 
 1 AS `id`,
 1 AS `code`,
 1 AS `cname`,
 1 AS `period`,
 1 AS `credit`,
 1 AS `dname`,
 1 AS `ctype`,
 1 AS `ttype`,
 1 AS `status`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_course_section`
--

DROP TABLE IF EXISTS `view_course_section`;
/*!50001 DROP VIEW IF EXISTS `view_course_section`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_course_section` AS SELECT 
 1 AS `id`,
 1 AS `name`,
 1 AS `sid`,
 1 AS `code`,
 1 AS `cname`,
 1 AS `year`,
 1 AS `term`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `view_course_dept`
--

/*!50001 DROP VIEW IF EXISTS `view_course_dept`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_course_dept` AS select `cd`.`id` AS `id`,`c`.`code` AS `code`,`c`.`cname` AS `cname`,`c`.`period` AS `period`,`c`.`credit` AS `credit`,`d`.`dname` AS `dname`,`cd`.`ctype` AS `ctype`,`cd`.`ttype` AS `ttype`,`cd`.`status` AS `status` from ((`course` `c` join `course_dept` `cd`) join `dept` `d`) where ((`c`.`cid` = `cd`.`cid`) and (`d`.`did` = `cd`.`did`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_course_section`
--

/*!50001 DROP VIEW IF EXISTS `view_course_section`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_course_section` AS select `cs`.`id` AS `id`,`s`.`name` AS `name`,`s`.`sid` AS `sid`,`cs`.`code` AS `code`,`c`.`cname` AS `cname`,`cs`.`year` AS `year`,`cs`.`term` AS `term` from ((`course_section` `cs` join `students` `s`) join `course` `c`) where ((`cs`.`code` = `c`.`code`) and (`cs`.`sid` = `s`.`sid`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-26  9:02:48
