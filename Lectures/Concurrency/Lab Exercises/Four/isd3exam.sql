create database isd3exam;
use isd3exam;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `isd3exam`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `Username` varchar(25) NOT NULL,
  `Password` varchar(60) NOT NULL,
  UNIQUE KEY `Username` (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`Username`, `Password`) VALUES
('1', 'a130334f77d5d86bb7d8e6894325221e'),
('alan.ryan', 'c395246f710b0e2c86b7ed82f7f56ce3'),
('brendan.watson', 'f3639baeb4530db03ef930eb16073f61'),
('carol.rainsford', '599dcce2998a6b40b1e38e8c6006cb0a'),
('des.ocarroll', '9b7d722b58370498cd39104b2d971978'),
('elizabeth.bourke', 'c6234e283c3ccfc2dad5469d5d98c739'),
('gerry.guinane', '030bb043d582f8f5569a8be85ea51911'),
('ita.kavanagh', '7c8c54bbcb0c6a411c5a87b50c3ac8b4'),
('john.jennings', '3518e159542afc83642c21dd643112a4'),
('ken.oakley', '09ef45a3371030c09e8497a2b562d5e0'),
('lindy.farmer', '0897747926d64dd6b27d892887021d71'),
('lorraine.callanan', 'feb789b85f47c1182e6c547af98749a7'),
('mike.oconnell', '7c6a180b36896a0a8c02787eeafb0e4c'),
('neil.higgins', 'd32787f6ce73d0611e541e2fedcad42d'),
('oliver.hyde', '87d08454821ecd4205704ae61aeb5c84'),
('seamus.doyle', '67057548df58d3cc208f89f6ff5e4e7e'),
('suzanne.ogorman', '98ded198ba3a0a30e7cc64e4a6a93f45'),
('willie.ward', 'fd820a2b4461bddd116c1518bc4b0f77');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
