<?php 
	/** **********************************************************
 	 *
 	 *	DEMO FOR: 	account-settings.html
 	 * 				_ajax/modal_address.html
 	 *
	********************************************************** **/

	// might be $_POST or $_GET
	$action = isset($_POST['action']) 	? $_POST['action'] 	: $_GET['action'];
	$value 	= isset($_POST['value']) 	? $_POST['value'] 	: $_GET['value'];


	if($action == 'get_state_list') {

		$array = array();


		// United States
		if($value == '1') {

			$array = array(

				array(
					"label"		=> "Alabama",
					"value" 	=> "1",
					"selected"	=> false,
				),

				array(
					"label"		=> "Arizona",
					"value" 	=> "2",
					"selected"	=> false,
				),

				array(
					"label"		=> "California",
					"value" 	=> "3",
					"selected"	=> true,
				),

			);

		}


		// Romania
		else if($value == '2') {

			$array = array(

				array(
					"label"		=> "Bucharest",
					"value" 	=> "1",
					"selected"	=> false,
				),

				array(
					"label"		=> "Brasov",
					"value" 	=> "2",
					"selected"	=> true,
				),

				array(
					"label"		=> "Timisoara",
					"value" 	=> "3",
					"selected"	=> false,
				),

			);

		}

		echo json_encode($array);
		exit;

	}

?>