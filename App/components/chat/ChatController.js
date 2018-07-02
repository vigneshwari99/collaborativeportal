app.controller('ChatController', ['ChatService', '$scope', '$cookieStore',
	function (ChatService, $scope, $cookieStore) {
        var me = this;
        var REST_URI = 'http://localhost:8008/demo/';
		console.log("Chat Controller Invoked")
		me.message = "";
		me.messages = [];
		me.max = 140;
		me.userId = '';
		me.imgPath = '';

		me.today = new Date();
		console.log("Variables Initialized...");

		me.addMessage = function () {
			me.currentUser = $cookieStore.get('currentUser');
			console.log("Send Button listened...!! ");
			console.log('$$$ ' + me.message)
			me.userId = me.currentUser.id;
			ChatService.send(me.message, me.userId,me.currentUser.firstname);
			console.log("After send() in chat Constroller ");
			me.message = "";

			console.log("outside message " + me.message);
		};

		ChatService.receive().then(null, null, function (message) {
			me.messages.push(message);
			me.imgPath = REST_URI+'/resources/images/';
			console.log("receive" + message.userId);
		});
	}
]);