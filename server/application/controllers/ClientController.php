<?php

class ClientController extends Zend_Controller_Action
{
    public function indexAction()
    {
        $client = new Zend_XmlRpc_Client('http://www.lukapeharda.com/demos/xmlrpc-test/public/server/');
        try {
        	//$data = $client->call('cf.test');        	
        	$data = $client->call('cf.getData', 13);
        	$this->view->data = $data;
        } catch (Zend_XmlRpc_Client_HttpException $e) {
        	require_once 'Zend/Exception.php';
        	throw new Zend_Exception($e);
		} catch (Zend_XmlRpc_Client_FaultException $e) {
 			require_once 'Zend/Exception.php';
        	throw new Zend_Exception($e);
		}
    }
}