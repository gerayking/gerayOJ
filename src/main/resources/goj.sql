CREATE TABLE IF NOT EXISTS `user_info` (
  `usergroup` char(1) NOT NULL DEFAULT 'U',
  `username` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` char(32) NOT NULL,
  `rating` int(11) NOT NULL DEFAULT '1500',
  `qq` bigint(20) NOT NULL,
  `sex` char(1) NOT NULL DEFAULT 'U',
  `ac_num` int(11) NOT NULL,
  `register_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `remote_addr` varchar(50) NOT NULL,
  `remember_token` char(60) NOT NULL,
  `motto` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `submissions` (
`id` int(10) unsigned NOT NULL,
  `problem_id` int(10) unsigned NOT NULL,
  `contest_id` int(10) unsigned DEFAULT NULL,
  `submit_time` datetime NOT NULL,
  `submitter` varchar(20) NOT NULL,
  `content` text NOT NULL,
  `language` varchar(15) NOT NULL,
  `tot_size` int(11) NOT NULL,
  `judge_time` datetime DEFAULT NULL,
  `result` blob NOT NULL,
  `status` varchar(20) NOT NULL,
  `result_error` varchar(20) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `used_time` int(11) NOT NULL DEFAULT '0',
  `used_memory` int(11) NOT NULL DEFAULT '0',
  `is_hidden` tinyint(1) NOT NULL,
  `status_details` varchar(100) NOT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `problems` (
`id` int(10) unsigned NOT NULL,
  `title` text NOT NULL,
  `statement`  mediumtext NOT NULL,
  `is_hidden`  tinyint(1) NOT NULL DEFAULT '0',
  `ac_num` int(11) NOT NULL DEFAULT '0',
  `submit_num` int(11) NOT NULL DEFAULT '0',
  `timelimit` int(11) NOT NULL DEFAULT '1000',
  `memorylimit` int(11) NOT NULL DEFAULT '512000000'
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `problems_tags` (
`id` int(11) NOT NULL,
  `problem_id` int(11) NOT NULL,
  `tag` varchar(30) NOT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `contests_submissions` (
  `contest_id` int(11) NOT NULL,
  `submitter` varchar(20) NOT NULL,
  `problem_id` int(11) NOT NULL,
  `submission_id` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  `penalty` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `contests_problems` (
  `problem_id` int(11) NOT NULL,
  `contest_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `contests_registrants` (
  `username` varchar(20) NOT NULL,
  `user_rating` int(11) NOT NULL,
  `contest_id` int(11) NOT NULL,
  `has_participated` tinyint(1) NOT NULL,
  `rank` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `contests_permissions` (
  `username` varchar(20) NOT NULL,
  `contest_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `contests_notice` (
  `contest_id` int(11) NOT NULL,
  `title` varchar(30) NOT NULL,
  `content` varchar(500) NOT NULL,
  `time` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `contests` (
`id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `start_time` datetime NOT NULL,
  `last_min` int(11) NOT NULL,
  `player_num` int(11) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;