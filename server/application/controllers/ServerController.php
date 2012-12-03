<?php

class ServerController extends Zend_Controller_Action
{
    public function indexAction()
    {
    	$this->_helper->viewRenderer->setNoRender();
    	
        $server = new Zend_XmlRpc_Server();
		$server->setClass('Application_Model_Data', 'cf');
		
		echo $server->handle();
    }
}

