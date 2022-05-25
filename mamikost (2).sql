-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 13, 2022 at 03:11 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mamikost`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_blok`
--

CREATE TABLE `tb_blok` (
  `kode_blok` char(3) NOT NULL,
  `deskripsi` varchar(100) DEFAULT NULL,
  `harga` int(11) NOT NULL,
  `status` enum('Penuh','Tidak Penuh') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_blok`
--

INSERT INTO `tb_blok` (`kode_blok`, `deskripsi`, `harga`, `status`) VALUES
('E4', 'Ini adalah deskripsi dari blok E4', 47000, NULL),
('ES', 'Ini adalah deskripsi untuk blok ES', 2000, NULL),
('F2', 'Fasilitas::Wifi, TV Kabel, Dapur, \nKasur Dipan', 245000, NULL),
('F4', 'Ini adalah deskripsi untuk blok F4', 47000, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tb_bulan`
--

CREATE TABLE `tb_bulan` (
  `id_bulan` int(2) NOT NULL,
  `bulan` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_bulan`
--

INSERT INTO `tb_bulan` (`id_bulan`, `bulan`) VALUES
(7, 'Agustus'),
(3, 'April'),
(11, 'Desember'),
(1, 'Februari'),
(0, 'Januari'),
(6, 'Juli'),
(5, 'Juni'),
(2, 'Maret'),
(4, 'Mei'),
(10, 'November'),
(9, 'Oktober'),
(8, 'September');

-- --------------------------------------------------------

--
-- Table structure for table `tb_fasilitas`
--

CREATE TABLE `tb_fasilitas` (
  `id_fasilitas` int(2) NOT NULL,
  `nama_fasilitas` varchar(25) NOT NULL,
  `kode_blok` char(3) NOT NULL,
  `banyak_fasilitas` int(3) NOT NULL,
  `tagihan_perbulan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_fasilitas`
--

INSERT INTO `tb_fasilitas` (`id_fasilitas`, `nama_fasilitas`, `kode_blok`, `banyak_fasilitas`, `tagihan_perbulan`) VALUES
(26, 'TV Kabel', 'E4', 2, 235000),
(27, 'wifi', 'E4', 2, 300000),
(28, 'Air Pompa PDAM', 'ES', 1, 40000);

-- --------------------------------------------------------

--
-- Table structure for table `tb_kamar`
--

CREATE TABLE `tb_kamar` (
  `id_kamar` int(11) NOT NULL,
  `no_kamar` int(3) NOT NULL,
  `kode_blok` char(3) NOT NULL,
  `max_penghuni` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_kamar`
--

INSERT INTO `tb_kamar` (`id_kamar`, `no_kamar`, `kode_blok`, `max_penghuni`) VALUES
(15, 5, 'E4', 2),
(16, 4, 'E4', 1),
(17, 4, 'F4', 1),
(18, 31, 'ES', 2),
(19, 3, 'ES', 1),
(20, 2, 'F4', 1),
(21, 5, 'F4', 2),
(25, 2, 'F2', 1),
(26, 1, 'E4', 1),
(27, 2, 'E4', 1),
(28, 1, 'ES', 2),
(29, 2, 'ES', 2),
(30, 4, 'ES', 1),
(31, 5, 'ES', 1),
(32, 6, 'ES', 1),
(33, 7, 'ES', 1),
(34, 6, 'E4', 2);

-- --------------------------------------------------------

--
-- Table structure for table `tb_pelanggar`
--

CREATE TABLE `tb_pelanggar` (
  `id_pelanggar` int(11) NOT NULL,
  `NIK` char(20) NOT NULL,
  `id_pelanggaran` int(4) NOT NULL,
  `waktu_pelanggaran` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tb_pelanggaran`
--

CREATE TABLE `tb_pelanggaran` (
  `id_pelanggaran` int(4) NOT NULL,
  `pelanggaran` varchar(35) NOT NULL,
  `jenis_pelanggaran` enum('Ringan','Sedang','Berat') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_pelanggaran`
--

INSERT INTO `tb_pelanggaran` (`id_pelanggaran`, `pelanggaran`, `jenis_pelanggaran`) VALUES
(1, 'Mencuri sandal', 'Ringan'),
(3, 'Pulang Melewati Jam Malam', 'Sedang'),
(4, 'Mencuri', 'Berat');

-- --------------------------------------------------------

--
-- Table structure for table `tb_penyewa`
--

CREATE TABLE `tb_penyewa` (
  `NIK` char(20) NOT NULL,
  `nama_penyewa` varchar(20) NOT NULL,
  `usia` int(2) NOT NULL,
  `asal_kota` varchar(60) NOT NULL,
  `telp` char(12) CHARACTER SET latin1 NOT NULL,
  `email` varchar(35) DEFAULT NULL,
  `foto` mediumblob DEFAULT NULL,
  `kode_blok` char(3) NOT NULL,
  `id_kamar` int(11) NOT NULL,
  `waktu_sewa_pertama` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_penyewa`
--

INSERT INTO `tb_penyewa` (`NIK`, `nama_penyewa`, `usia`, `asal_kota`, `telp`, `email`, `foto`, `kode_blok`, `id_kamar`, `waktu_sewa_pertama`) VALUES
INSERT INTO `tb_penyewa` (`NIK`, `nama_penyewa`, `usia`, `asal_kota`, `telp`, `email`, `foto`, `kode_blok`, `id_kamar`, `waktu_sewa_pertama`) VALUES
('35132321', 'yudha', 21, 'Jember', '089745341', 'gurindam@gmail.com', 0x89504e470d0a1a0a0000000d49484452000000930000009e0806000000367b38cb00000104694343504943432050726f66696c65000028cf6360609260000216030686dcbc92a22077278588c82805062490985c5cc0801b3032307cbb062219182eeb32900e3853528b9381f407202e29025a0e343205c8164987b02b40ec2408bb07c42e0a097206b21700d91ae948ec24247679494109907d02a43eb9a008c4be0364dbe4e6942623dccdc0939a171a0ca423805886a1982188c19dc18981ca00119ef98b18182cbe3230304f408825cd6460d8decac020710b21a602f4037f0b03c3b6f30589458960211620664a4b6360f8b49c818137928141f80203035734a61d88b8c0e15705b05fdd19f281309d2187211528e2c990c790cca0076419311830183298010092a540b32b57e2090000000970485973000016250000162501495224f000001fb349444154785eed9d099454c5b9c7abb7e9996111041ea227080f8c201035b8041163ce51c03d4fcdc9c21293a8e00998800b6ee80ba80f4483065040e5f19e1037d4248aa8901741103750d914195904119c01544666ebe9fbbeff57f575dfe9199c9ee97b7bba39f5d3a26edfa56ed557ff5b55b76e554dc02194c5e20141e35b2c1963c564f10c2b268b675831593cc38ac9e219564c16cfb062b278861593c533ac982c9e61c564f10c2b268b675831593cc38ac9e219564c16cfb062b278861593c533ac982c9e61c564f10c2b268b675831593cc38ac9e219564c16cfb062b278861593c533ac982c9e61c564f18c169d1e7ef060b9dab56b97dabe7d9b7aefbdf7d4ca952bd5a14387d499679ea97af7eead4e3ffd74d5a95327d5a54b1773c591cdc71f7facf6efdfaf3efcf043f5c61b6fa89d3b77aaef7ffffbea873ffca13af9e49355870e1dd82e390bc4d4124c9932d5e9dfff0c27128942cc8775ddbb77776ebef966a7acaccc5c79e441c2717ef18b5f38e170a8411b880b87c3ce8811239c65cb96992b738bac8be9d9458b9c8e9d3a1b03051c1508396112144405bf205ac47e285cc02e69cc8073cbadb73b55555526a4fc67fffe034e9f7e2727d3c8b6d0e9861dc4c11ec160d889141426ce1d74ceb9ce8e1d9f99907283ac8a69e2c4bb12c680610264a0c2a2565a4cf41b460c8692c60c931f2d2c4e9c8beb8e39f63867cf9e3d26c4fce5a597163bedda77d0f62011219dc15084d30a079b88c36f1c873d5858749ed871faf4e926c496276b621af9ebab38f152e2402cf0d948c660a90684af0516e1f3708d18319f79eaa9a713e99092070e0f16d28bb4bbf78bc33ed802db388f4b760a63ca942926e496252b0df0dbeeb85dfdd73df72a2a5d54281462575b1b57814050c5e38e0a06b56d1193402000a5f075c16030b11d8fc715b519546d4d8d8ad5d6a8f6eddbab92921275f4d147f3f17c61cd9ab5ea0c7ac120d3ab8268818a517a600fa44fd20e5f48fd8df3703e706a632aeec4c996b5eaef7fffbbbaf4d24b797f4be1bb9856ac58a17efce31fd356508523918461ea1a0951488a08886105fc4e1ad251d55595eaf63bee54774ffe933e214f68d3a68d2a2f2f5754fa246c20e9c4c3e3169520bf711cc291f34221edc76a62aa35857bf09bafcc152d83affd4c070e1c50a3468de2ed6861947d50d788705a54d8272ef5b718938d17ab256146d53d774f527bf6eee573f381dffef6b72ca4503842e9d1e9039246b790641f9c9c83e3525a6b1fb60cf0435a7ef06b75e14517f3b92d85af6242a984be13544f30049e2ae03610fdcbdb8d21d780828202362818758d166baeb37dfb76f5fcf3cf733a0a0a222a6e6ce1a6ae5dea937a1c3640e9a47f07d4db6fbfad366ddac4c75a025fc53461c204f691582437cc4fa41641734158555555baba0b84d4b27ffe9ffae8a38fccd1dce585175e505f7ffd350ba9aab25a458b74359729f290161615abfdfbcad4b265cbcc91ece3ab98366fdecc990e21c528c10e3516e5a96a2e52c4039478870e1d544f3ffd34ffce65de7df75df6a11fc4bbbaaa3a235bc00eb81eb6407855082f1852b7de7aab3923fbf826a6d75e7b8d7dce784a74844aa54c1103c2615b9eec58ac86fd5ca5a2a2423df9e493fac142dce93ff2320661d5d0db20809d113e3e47b514be8969cf9e3dec23c1201eaf4d6c7b85945025259fb29fab485b11992d0f41a6b6c0f5a8e2502a21bc60104d096feddb547c13d3ded4b72c4abc94249900238a212543d0c897273417a9acac645fd2efc493a56a2648fa610b860405f016dd12f826266e201362b4a01140268888004a25f7762e23f1834df821a03730ecf34250023f64665b4ac26ce35b2eb46ad58a7d5d0cc7559c0c27c57ca688a824acae5dbbaa4824f336995fc00600f10d4158e4b3a84cc992090813e1b02d8c69dbb56ba737b28c6f62fac10f7ec07e2c1663df31a548a606c4f5f81483273b6432a96fdf3eece72ae81703d5d5d5ec7bd5b4112149298d863d10f1661bdfc474c61967b08f4406831172f81e9759f12b651abee5c5e3318abc182fb35209edad197f99a9ce3f7fb01a3af4423578f0103564f050dabe400d1f31527db86e9d39b379141616aa0b2eb840971e64072aa85900fcbb99e05a84019be2fd10cda5863a42b30a45ca37ce3aeb2c584b7fedc67013d70881e6b830fc4801b988138dea4175549d3aebd7af37774c1f12b9b36ae52aa753a763389c74dc8d374d70f67cd1bce12f3366cce03090068c80c0909a86d2d814170a459ca2a2566c0f3884ffc8238f983b661fdf4a2670d55557b15f43555d3852c01d9719b713c8647822a5fa4409d8b76f5fde4e17f4c50c3c6ba01a78f640555aba97da72114582e78fafa90efb83741c231eee9f36559dd4a7af7af891d926a4f439edb4d354345a40a5479cab3bf727a1e612801d3072804a7fb8e2e2623560c00073b405d09af287afbefacae9d5ab173f31c1503831468732a9592e1cc1381ff2c361760877e7ce9de66ee9f1cc33cfd0d35cccd7224c8c0b2a2a6e5d67609adbb907f0a1242029f3b5c3868d7062b15a136a7a5c7bedb5e6bec9f15aa9f74bd7e15a3da08ee25fa4c7798d1c39d2dca965f07d08caabafbe4a6d8fa1dcae71d0580ce8afdd94763e2e2515a2915a6a49d4b05f8ec7e9490c8743fc7deee73fffb97aeaa9a7f89c7458ba7429b58706d316beb4eb9221882e0c739f864c218d5b38fd66aa9bb9b1ea4a2a0506aa37df5ca94f4c138cc3a2878c4abd2885a5d38b644bfac407ee6d21f5385cbc56f7b1218e2d89afd51c18326488bafefaebf993071accda185a20623c20dbe2649fec171f990f21f5ecd953cd9e9d7e75f3fefbefab2bafbc92b79191082f42e2a8a5ea52c26e086ee0d2710829f10241e752db47ad5ebd4a8d193356ef4b132a19d977e23a2c0abacebd252e926620c753f7c96ff8f890dce25044b2c2e5975f0e8b7043b1c014d352ccc3972a30144eee43b5963c4f1f4718edda1de57cf3cd3726e4c6a1b735a75bb7ee7cad0c134e86abef81090d5285a43af7b9fc1b3efdd6d59e72fefad727cd9dd263debc797c1d1c2610206cc40b55aebe971eb68b7bc9305eecc3764194aa36b34fc6c52f58b0c084dcb2644d4c54043be3c68d4b18b1b0501b0b4683b842d4a6c29b1af653d542fb212cec8bd03e325c408f77eedab5abb379f366136a7acc993b97af95ccd29963c481ccc3fd49acdf2528b7e3cc47bcc921dc3e7dfa3579d6ccfcf9f313b60885757b0de1455d6d42d80376814d0ad0cea2dfe2cbb5fffb446e0809644d4cc2e2c58b9d134f3c31610c6a4b912161209458305e88c583df78fd9786368e8d1d3bd684d234f4ab78841bd9f2c4b3984448b42f484f7cba6282e312831cba3b10bf575e79c5dc2d7da8da74ce3fffbc842d50d2413cf4d6c7e99507891fae82647708dc65975de694971f3421e506591713a0576367e6cc99ceb1c71e9b30ce77b9db6ebbcd59bb76adb9ba69cc9e3d87c38078ea0889051c6511896b52c944222ac0f9e4107e8f1e3dcc1d9bce92254b9c2b4c33a03147edbe9ca9d652f14d4c151515ce1faf1feb6cdcd87887e25b6fbde50c1830c039f9e4939d534e3985aa8d3ecea449939c43870e99330ecf030f3ce0bcfdf6dbe6577dfe306e3c6702441008845850285542115d1a35474c70dc9540e7a38a16417d173367fec559b4e819f3ebf0ecddbbd7b9eaaaabd806a79e7aaad3af5f3f9eedfbd9678d4fb884281f7bec31f32bfbf822264c923ce79c73d8c06ddab47656ad5a658e7847696959622e5eab566d9cc52fbf6c8e24f9f6db6f13bdf061aa32501a25faaad0b82721b85d53c4841705f43eebaa538b69d3a64de6ce7541f58ce370f7dc738fd9eb2d28e9e51e53a74e357bb38be7624243140d52240af53d7cd4f513264ce04e4c2f58be7c3965bc0e1b558e18f1f5e5af9b33343b76ec703a76e8c08d77b441d0167137c2593c6e972298c3395dcda1a3136f57f43baadfea468f1e6dee9ce4f7bf1fc3c7d0fe417b10db679f7db6b375eb567346666cdfbedd193a7468e21e685f611b2f3bd9c673315d76d97f7062b00883341ee54decf8e38f771e7cf04167c3860de6ecf44195f7c20b2f3883ce1ec4612915e04cc59b50b4480beaeaabaf36676b4a4a4a9cd6ad5bf3316ed093a04448094135c3e96bd1c5a04bb960448b24b5077aebd66d897be345020f95080a6ecc9831ce8a152bccd94d03a5fd0d37dc90080be14ba31d0efb162e5c68cece0e9e8a69fc789d383cfd5112528884840fb1925049787171b1f3b39ffdcc993c793289e45b73757d62b198f3e69b6f3ad75c738d73c2092724ae47ff8a2e1d90a1644053328c1d53f76d0f4fff51471dc5c7d8c8148f9047622a88b6a26d33c5bd489792c3870f3777d6a06484e80301bc8de98c86a024b3255e682fde7cf34d8d9656a5a5a5cebdf7deeb9c79e6197544a94bdd283fbc2258d81c0fd2071f7c60aef61fcf3ea72c5bf64f45afb98a8cab3f41d4d6f2670ff41ae3063c288c408f6d55951ec62a74e8d051b56ddb96c727a17f17d7d4c46ad4cecf3ed3271822113d2e284e0192b1f8632fc2a3bc523555d56accd8316ac65f66f039e0cb2fbfe40fc194a97c7e08c360e85a2419716c3e7808f159089f5842aabaa65239b57175fffdf72b2a2dcc394a51c9a47af4f8778e7720a8c71de1232fe28184626c64757595395b535454ac3a1fd35915469353a1600f1292fafaebe48cdda2e2629ec92b69c1e0438c19c3366c82dfb19a6ad5e9df3aabcd1f7fc49f71fcc63331753dbe1b65fe0efeba4e4f4ae23304c01d30e01deb0a2003e869e43144721cf3edd9ba4ac6e3609b1c19261c2281d126a28988c258ee8176f81e0531c5aa6bd475d75da71e7ef8613e26fcf297bfe4ef77b8277002fa5b9cdcbb796831214d484f6dbc5ac56371450d7efe722f7cfae9a7fcd987c77385e461d222d4e073918cf9c22854cc568e51f038eece163c307a8d06a41fb6c5b67c8b93b4c0879dc42e205653a5264ebc534d9ae4ff347a4fbecdfd61dc1f594854fc7309c0190f05113a71da60f0610c184c9e201021f18523e1c4b00f7c3bc33e7c3bc32962208c238790b02d86c387639c034a3e2de1211e6eb0ea1a1003e37c6fa0f050ea723a7504dc42025bb66c613f14a67b26e29c8c3ffdcff003620406d1ebf4bb87c244593c400b4f7f7c96701007381110c4867c00a829264f9ea4b66edbc6bffd2463cb7e4655d182279ee06d241248820112ebf64143dbee7da934762d085275b3f4b5a56af3279bcd1e0d3e34030818d58d548d5a04cd0397f2ad8d8bc76ad5af7f3d928fb99936ed7ef6e931d01761db156737d87fb863408ecb39ee73ddc7f80123db63460c7c11e1f871e3334a733a642ca63f51f1b97fdf7e458de1c4d3e277a453c1ddc4689f7ffe39fb02c6a2631516c4ad06ed95c4dcfccc9030306d09dc79e75decbbc13a9d01aa5675059d5da821ce2514975614877fbcf8a2ef53c7336e33c1a8e1026a8f98419b084eea732f32ad5128f64e10e3a003dc083fe9a493d4c68d1bcd41cd9a356b78a423da38e18222ae9e32891bd21808a03aafa53649a5bae8e28bd44b2fbe648e6ae6cd9ba77ef7bbdf516918652965c51606b7eda54a44db092f2358dcc22f322a99468c1ca13728de88bc940ed92899700fb90fcc0683458ba2bc0ac8be7dfb78bfd0bf7f7f6e9ce305a0861aea886b228ef01b73acd8a4433e71069128dbb7efd0e05a0758f104f09b9b211b7601489fe407aa75b49fc2d4767ae79d77787563bf68b6984acb4ad51b6faca412948c452529ec846255da4a7e9110903118aa10278e7289b64de3bba115d4a64e9da2faf4e94be7d6e892c93cb17184816df2659b1d56b5c36ff84ef21cf82c5f87de4029acb97367ab56c57a8ea0b064c912b578f162dd463383e0106fd806bedfa262bb206de4704f6e2762fa0a71d75dffc9be1f343be717bfb458edd8be9d9e3cbc716141069308632c6c7b8d3b5c180860e4259e7e2c8c819207ac5bb7ae5e55d7a64d5bb56ad54ad5b56b7712bd16140c1d08610425244972a46d04112351d622c3295c1619844a3f75f0549d5657d2353175df942989d19b6e162e5cc87e4d8d8923dd07a5041e36a4419a017e8287a56e3e50fa28af962c7945eddefd85d9e72dcd16d39c3973cc565d10793f8424206c29bab18d61b710474d4d35efefdebdbb7aebadb7a814aa3f31f3a8a38ea26a70bdbafcf22be9ba6a6e9053634245425425909ce2d555ec47e829860b60bc396466e6e8615facea903afae88edc46bac9ac3f95ca82050bb8bd84221b71449f9a941210127e4b29e527a9f9806e872fbef85cfded6f7f337bbca5590d70641a2216a427199d6d7e8aa721106529bed1b31e2231e055b85bb76eea5ffffa17fb8d317ffeffa851a347a9ea2ad3034dd559181d8b480b59449284d9c358c14518366cb8bafbeec969dde3e28b2fe6ea0e6fba522ae12140bc454cd9b29dd8acbaaa420d1e3c54bdfaea1273c43b9a2526ac0877df7df791918ad8d8d9149318453ae674a3ba4275ecd89117d44a2793dd3cf5d4936ac1c227d51a7a8ddfbf7f5f720a3781fba02312bdd8e79d779ebaf1c61b55e7ce9dcdd1f4b8eebadfabd9b31fe6ce43944a081fafed22a86ce1ce66bcd9a1aaebd2e518b3c71b9a2526542558a3b1205ac862cab6512022640aa64f5553b503f07757060e1cc8db6e264f9eacd6af5f9f98157238901ef45161399a6fbef986ef81bfdb82a5a121265988a321962d5daafe3c7dba7af9e597cd9ebaf43fed0cb576cdbb3ca1130f81b49fb26537d80c0f3c7cdc13a5d382050ba994fd9539c32320a6a6400d5ba76ddbb6f45213e4f1cf018c386ce0cbba1f4ebef48b8f2ff648c2334f3f6d6257170c09c171b8debd7b7b3e488f4a17e7f6db27baee7152837fe3a5b2b2ca69cf7f8d20c083e930a9f370933efd706e7b45e9de88eb80b3ce36b1f38e268b69dab4691c99e2e222923b09cacc764d4d801f0ef7c1b05b6404869f201ed75c3bcac4ac2e188c87e3185de91efef2d0430f99333263f9f2154e5ff3774f74bc747c7af63cc19c5197e79e7b9e8f23ee385f0f9fc98edde0e49e101486f0b46ddbded9b56b97899d3734594c32c5391cc2dffbd0e3791a8abc5f4e8c823874e8d0c9c4aa2eb366cde2e3981284e1b5e1023df30533613843a9547d7cde3c67f7eedde68af4c028d275ebd6f1484984839206f1810d4418d88f21cb0d317cd8083eee3e3f1b0ef7829309157aa64e9804fe9c89993734a9cd8469cd322e068d482a9ab8019cedb739b4373025fa1fff78495d72c94566af06337765a400165b47ef0762c79d94741d7cbc9a2b47bfa161a17734da4f39e5143568d0d9d4366acd6faaa0bcfc20b5a576a8a54b5fe3b151e83fdab953f7206361780c2741d2f5b012ddbf86f65055e5210ef7f1c71fe773dd506672e35bba36b201e2857b497b0ddb6837a1fbe2b1c71e3367654e93c424e3730a0ba32c22cc957728627e9a440c8148e23e5a48313560c059f5e6f963da787f12d2c64d9b120b6cc5317e8932bb3656a342140e1aa00803e0a32ffe6c06c03d3a77eec2990c07aa497407a9317ef0e0d7fc1bc284d0d09b1c0a15a84abab6804722249761467c83813877586ef9e413d5f3841378bf3067ce5c357af4287ebb83b0ddb6d369c596f71645d8d2c7c52f3024a62143067327a6c43d539a24a6e9d31f54e3c78fe3cf0400628261b511fc3100325f9728143ec514f7a9aeae541515952c6a3763c68e55b366ce24a38579301a7ae66b217a3a863e247c6210a3c2c7b7b510058bb15410a22c242183ef38679db82a2c6e45afd335c9f8d0713c4c1873856f7d0505c9be23c40feb08a013b575eb3654a2ed554545453a3c02a323fb9f7eba5af7e107fc76e7ee09479f1d7eeb21f3dedb53c03d90462c70bf6ddb5675cc31de741134e9dd74ea7dd3d847b73cd9d25721092885605c270e1f6b1b55aaa14387d413525969997aecf1ffa62d59e144c7093dd721ba1e8294b872e946c6448727bebdd5d4a0f88fb0c8e078601e1c954218980621e13a8885c3241fc375f58a2c66f5363a2e76c027c2c2e2d65c4dce98398bf70910ee1fff70bdfe01cd187103feac837d3e81f473bae97e28152b2b2bd4962d25e668e634494cdf9697d3138f6f60da78625cbfc03d605bfdc4a35da2f7cba03337bf1a315255557ccb7d5ff2b47375c619ac335a32bbceb6f9cddbaefd6e1ada07dcd701c9ac0809069f6a60ab0937dfc47f6bd7cd6f7ef31b554ca51d1e0c5c2b62d4624ea6d34b521f7a9482e09d77bc1b9292b61acacacaf80bb86414ea5d14ed882022ea073a63226c6c080af5fd85175e586fa5b875eb37a87f2e5d6a84aebf96f3d3e7325e36718b03dc7efb6decbbd1cb0151a98436988927da5e7e2cbe2f205c38d8476ef1faebafeb0d0f485b4c18ec5579889e7c2afe211e11925f09075a40f484938ffb815b6eb9857d379327dd4d068a71e6216e10ba6468b6c0bd1aba2704fec482056aebd6ad668f06dfed7af4e849362d37998b35a0f403e0d7c329a5131cda7c2805315cc62bd216d3b6c30c481743f80112af8b6387330add1283060dd2070d5b4a4ad48b2fbea8db711417080fbe5f19f25d40cc620f1136e283bafaa1071f346769dab76fa7ce3df71cdec6393897bb2c083fec8930718f449c789f6eefa1d6f182b4c5843f260324c3fc12507d44508a3f2ea782eaa2aaea10679ec4c96db06c23f74d9652e4c8c7186cf455b9b9f1861be998ce50c45f44e517621fe4a11b74f978415a16c71383898cc09d61d896df5e93089ffe93bf3df2939ffc847d377f7ee0013a4f0b49e2e2579cd245e2ae7d2d307c485ebe7cb93943d3ab776fd5addbf1f4665c4b693cc4afea7e8a0948bcb4c6b59d9e7df659f633252d31e16d64f5ea37e9e6c995efb39d613ffde94fa98dd1c3fcd260c153208b9de60a621b9d71e8e3d2769b32650afb6e781f951418bf5e5d5345c2a36b7d4e8a3b7e20ab2513a626e38fe38523188798658c4852db4a60ead4a9ecfbf906e405881a5e0ad6ae5d9b286585c1e79fcf7e6dcca4815cf66cacef246db54c494b4cd25ea2941a3f7b54d3db1cfee2f6b061c3cc1e0dc61d7df1851ecbdc52eda374803e62b57873d2a5d3a38fce655fc04bc525975ecad3dbf167e55b02fcb957f7a0c0e692562e245afb24e46cc809cf0b3fa5a654eadead5bbd118e18ec86694d858585664f6e82ea1762c75f3c87f59e7966913ee062c08f7ec47e8404a7a7bff3cf2c80766690bb2de48f4d66425a624a361cb35700c39ef87c02468d1ecdbe9bf566f6093e5d20c372a9cd940aded4b442026ae3a68fd4279fe8350804fc890a1ecaeb5175933e587c23ac76efde5dff8f4d3683b4c43473e64c7ebaf4b738b3d3572022fd2403fd5705ea326bc60c36045e7339b3721494b06893208e5832e8c0fe321e26e3e6dc73cf55c71d779c9221d0d97d2ef4cd52a7d53787b41b1bb2244e368b60d4e3ad5bb756dffbdef7cc3e4da9a976315e099924bdf1b94a6adc1afa842153b3b08a4b369322edcd83070fb29f09698b899f962c0a49b8e28a2bb80a703377eea3eca354921ee75c05d52fe207c1eb71528106fb75264e9cc83e0fb5c922623b34c233256d31f14d1ddde1e5a74ba5a1a94bcf2d7a8e7dc409d7889f8b48dc2024aeeec211b56f5f59bd6a45468782749322366b8ea37fb46f904ee94c688298b461fc7002b63979d464c227060c2a437bc20dfa69f4dfeed79f1e52c3c835248ed2b693b8a62e6f836398a387a12ba9c9812d5271a73d1327d59c170b5a342aa6e41384274c7f40f5da49c218fa8d58c1805dba7451fdfaf5d3fb0defbeb7863f3a638d017e29a0eb72b9aa73c7cf1dc7d5ab579bad24575f7d35fd5bdf3e105aea3e90baaf394e84ba7973dd45d29a43a362c282554032ce0f2720717c1ff31b55032641ba797fed5a1e5406032393f201773ac55fb16245bddef05ebd4e64df6d1341c210e7557ee8ced440bd37cce6d0a898b050164003d2af9209b87dd9bee4924b38c16eb66fd74361604c3937f59c5c42e22725802ea582dc49985ab5b897e69134892d24ade2104eeabee638ace6025b7a41a3a1c8229f30069602c63c75af1d96a8a9bbadbbf64f3df554f6dd7cf0c187662b595ac228b90ce228f1e46d7a6343633c751cd189bd7ab10f1b884df46a2d49fb78e96a8c732fcc91098dce4e993f7fbe5e57804758eaa725f5f515066a8c866ee3be0e7d5800eac61ad6070e94a93bee98a8dab56bc7fb01d6c16ed7ae3d4f1392a7094fa85479e9c423db48ba115f3c90dcfea1ccc308d2471f7dd4b493923cfef83c2eb10a0b8bf86504b501c6732566cc00934e59a1b739b0b0c9d71da5016a1bef52b366d59dfcd0549a34d5a9a5c187dd638f3d9627324ab42120364c0e0a49488d2bc480bff13b6efc0deacf0fd49f1c91af7853596689d2d2e44845648c082897850452e32ab1ddb07e83d93a32c82b312d329d95470abb3eff3c3151e24820afaa394c4dc7a8405473f90e1ae068179595eef9ceb59ff289bc2a992a2af4c25e47026888575694d79ba099cfe49598d03f43ff667154957f481b6ac386baab02e7337923260c91901ee3dc6e6ea78788a9acaceef4a77c266fc484ef71f8135cba743a72f8f2cb52b395ffe44dce6cd8b0814b26fcb9adfc7965689cc3cd94ce47f2464c25257ae917eea53912ea3903a63f1d29e4559b09e02d28df8ba6646f8c9e19923a7a205fc91b31c95777fd876d72b7688250525d2a89de70fea6e89e9798dfe48d98c4e0c9d14eb9097f2e49710d090c1fa6f9cfc4d235b664ca3298c10b282bf4bf0d64502eb886684860321e2b16c322ac99cf0cc905f2464ce5e5e5ec6381517ccfca558731dcf55d4dfd7d742ed6c4c4b1aa943f479fafe4c5b739cc9f1b3e7c380f75c574f04ca34c05838f7c77e07294cb574a074a29fcc92eac439eefe4cd875eacc482aa41aa874c40066693efba1fda821d3a74e0c187f94e5e8d1ab0e43679d366b2e43e564c16cfb062b278861593c533ac982c9e61c564f10c2b268b675831593cc38ac9e219564c16cfb062b278861593c533ac982c9e61c564f10c2b268b675831593cc38ac9e219564c16cfb062b278861593c533ac982c9e61c564f10c2b268b675831593cc38ac9e219564c16cfb062b278861593c533ac982c9e61c564f10c2b268b675831593cc38ac9e219564c16cfb062b278861593c533ac982c9e61c564f10c2b268b675831593c42a9ff07fa52977ca8d58d1b0000000049454e44ae426082, 'E4', 20, '2022-05-13');

-- --------------------------------------------------------

--
-- Table structure for table `tb_tagihan_fasilitas`
--

CREATE TABLE `tb_tagihan_fasilitas` (
  `id_tagihan` int(3) NOT NULL,
  `id_bulan` int(2) NOT NULL,
  `tahun` year(4) NOT NULL,
  `id_fasilitas` int(2) NOT NULL,
  `jumlah_tagihan` int(11) DEFAULT NULL,
  `status` enum('Sudah Dibayarkan','Belum Dibayarkan') NOT NULL,
  `tanggal_bayar` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_tagihan_fasilitas`
--

INSERT INTO `tb_tagihan_fasilitas` (`id_tagihan`, `id_bulan`, `tahun`, `id_fasilitas`, `jumlah_tagihan`, `status`, `tanggal_bayar`) VALUES
(6, 3, 2022, 26, NULL, 'Belum Dibayarkan', '2022-05-18'),
(7, 4, 2022, 27, 400000, 'Belum Dibayarkan', '2022-05-14');

-- --------------------------------------------------------

--
-- Table structure for table `tb_tagihan_penyewa`
--

CREATE TABLE `tb_tagihan_penyewa` (
  `id_tagihan_penyewa` int(11) NOT NULL,
  `id_bulan` int(2) NOT NULL,
  `tahun` year(4) NOT NULL,
  `NIK` char(20) NOT NULL,
  `jumlah_tagihan` int(11) DEFAULT NULL,
  `status` enum('Terbayar','Belum Terbayar','Belum Lunas') DEFAULT NULL,
  `tanggal_bayar` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_tagihan_penyewa`
--

INSERT INTO `tb_tagihan_penyewa` (`id_tagihan_penyewa`, `id_bulan`, `tahun`, `NIK`, `jumlah_tagihan`, `status`, `tanggal_bayar`) VALUES
(22, 4, 2022, '35132321', 48000, 'Terbayar', '2022-05-13'),
(23, 4, 2022, '3415473646', 3000, 'Terbayar', '2022-05-13');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_blok`
--
ALTER TABLE `tb_blok`
  ADD PRIMARY KEY (`kode_blok`);

--
-- Indexes for table `tb_bulan`
--
ALTER TABLE `tb_bulan`
  ADD PRIMARY KEY (`id_bulan`),
  ADD UNIQUE KEY `bulan` (`bulan`);

--
-- Indexes for table `tb_fasilitas`
--
ALTER TABLE `tb_fasilitas`
  ADD PRIMARY KEY (`id_fasilitas`),
  ADD KEY `kode_blok` (`kode_blok`);

--
-- Indexes for table `tb_kamar`
--
ALTER TABLE `tb_kamar`
  ADD PRIMARY KEY (`id_kamar`),
  ADD KEY `no_kamar` (`no_kamar`),
  ADD KEY `kode_blok` (`kode_blok`);

--
-- Indexes for table `tb_pelanggar`
--
ALTER TABLE `tb_pelanggar`
  ADD PRIMARY KEY (`id_pelanggar`),
  ADD KEY `NIK` (`NIK`),
  ADD KEY `id_pelanggaran` (`id_pelanggaran`);

--
-- Indexes for table `tb_pelanggaran`
--
ALTER TABLE `tb_pelanggaran`
  ADD PRIMARY KEY (`id_pelanggaran`),
  ADD UNIQUE KEY `pelanggaran` (`pelanggaran`);

--
-- Indexes for table `tb_penyewa`
--
ALTER TABLE `tb_penyewa`
  ADD PRIMARY KEY (`NIK`),
  ADD KEY `id_kamar` (`id_kamar`),
  ADD KEY `kode_blok` (`kode_blok`);

--
-- Indexes for table `tb_tagihan_fasilitas`
--
ALTER TABLE `tb_tagihan_fasilitas`
  ADD PRIMARY KEY (`id_tagihan`),
  ADD KEY `id_fasilitas` (`id_fasilitas`),
  ADD KEY `id_bulan` (`id_bulan`);

--
-- Indexes for table `tb_tagihan_penyewa`
--
ALTER TABLE `tb_tagihan_penyewa`
  ADD PRIMARY KEY (`id_tagihan_penyewa`),
  ADD UNIQUE KEY `NIK_2` (`NIK`),
  ADD KEY `NIK` (`NIK`),
  ADD KEY `id_bulan` (`id_bulan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_bulan`
--
ALTER TABLE `tb_bulan`
  MODIFY `id_bulan` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `tb_fasilitas`
--
ALTER TABLE `tb_fasilitas`
  MODIFY `id_fasilitas` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `tb_kamar`
--
ALTER TABLE `tb_kamar`
  MODIFY `id_kamar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `tb_pelanggar`
--
ALTER TABLE `tb_pelanggar`
  MODIFY `id_pelanggar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tb_pelanggaran`
--
ALTER TABLE `tb_pelanggaran`
  MODIFY `id_pelanggaran` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tb_tagihan_fasilitas`
--
ALTER TABLE `tb_tagihan_fasilitas`
  MODIFY `id_tagihan` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tb_tagihan_penyewa`
--
ALTER TABLE `tb_tagihan_penyewa`
  MODIFY `id_tagihan_penyewa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_fasilitas`
--
ALTER TABLE `tb_fasilitas`
  ADD CONSTRAINT `tb_fasilitas_ibfk_1` FOREIGN KEY (`kode_blok`) REFERENCES `tb_blok` (`kode_blok`) ON UPDATE CASCADE;

--
-- Constraints for table `tb_kamar`
--
ALTER TABLE `tb_kamar`
  ADD CONSTRAINT `tb_kamar_ibfk_1` FOREIGN KEY (`kode_blok`) REFERENCES `tb_blok` (`kode_blok`) ON UPDATE CASCADE;

--
-- Constraints for table `tb_pelanggar`
--
ALTER TABLE `tb_pelanggar`
  ADD CONSTRAINT `tb_pelanggar_ibfk_4` FOREIGN KEY (`id_pelanggaran`) REFERENCES `tb_pelanggaran` (`id_pelanggaran`) ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_pelanggar_ibfk_5` FOREIGN KEY (`NIK`) REFERENCES `tb_penyewa` (`NIK`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tb_penyewa`
--
ALTER TABLE `tb_penyewa`
  ADD CONSTRAINT `tb_penyewa_ibfk_4` FOREIGN KEY (`id_kamar`) REFERENCES `tb_kamar` (`id_kamar`) ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_penyewa_ibfk_5` FOREIGN KEY (`kode_blok`) REFERENCES `tb_blok` (`kode_blok`) ON UPDATE CASCADE;

--
-- Constraints for table `tb_tagihan_fasilitas`
--
ALTER TABLE `tb_tagihan_fasilitas`
  ADD CONSTRAINT `tb_tagihan_fasilitas_ibfk_2` FOREIGN KEY (`id_bulan`) REFERENCES `tb_bulan` (`id_bulan`) ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_tagihan_fasilitas_ibfk_3` FOREIGN KEY (`id_fasilitas`) REFERENCES `tb_fasilitas` (`id_fasilitas`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tb_tagihan_penyewa`
--
ALTER TABLE `tb_tagihan_penyewa`
  ADD CONSTRAINT `tb_tagihan_penyewa_ibfk_4` FOREIGN KEY (`id_bulan`) REFERENCES `tb_bulan` (`id_bulan`) ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_tagihan_penyewa_ibfk_5` FOREIGN KEY (`NIK`) REFERENCES `tb_penyewa` (`NIK`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;