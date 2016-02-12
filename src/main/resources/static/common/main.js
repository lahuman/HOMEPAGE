var Contents = React.createClass({
    getInitialState: function() {
        return {
            title: '',
            registerDt: '',
            content: ''
        };
    },

    componentDidMount: function() {
        this.serverRequest = $.get(this.props.source, function (result) {
            var lastGist = result.content[0];
            this.setState({
                title: lastGist.title,
                content: lastGist.contents,
                registerDt: new Date(lastGist.registerDt).yyyymmdd()
            });
        }.bind(this));
    },

    componentWillUnmount: function() {
        this.serverRequest.abort();
    },
	render: function(){
		return (
			<div>
			 <h1>{this.state.title}</h1>
	        <div className="descr">{this.state.registerDt} by lahuman</div>
                {this.state.content}
	        </div>
		);
	}
});

var ContentFrame = React.createClass({
	getContents: function(){
		return <Contents source="/notice"/>;
	},
	render: function(){
		{/*
	        <h1>Adipiscing</h1>
	        <div className="descr">Jun 11, 2006 by Laoreet</div>
	        <p>Aliquam risus justo, mollis in, laoreet a, consectetuer nec, risus. Nunc blandit sodales lacus. Nam luctus semper mi. In eu diam. Phasellus rutrum elit vel nisi. Cras mauris nulla, egestas quis, cursus at, venenatis ac, ante. Fusce accumsan enim et arcu. Duis sagittis libero at lacus. Suspendisse lacinia nulla eget urna.</p>
	        <ul>
	          <li>Tristique</li>
	          <li>Aenean</li>
	          <li>Pretium</li>
	        </ul>
	        <p>In hac habitasse platea dictumst. Duis porttitor. Sed vulputate elementum nisl. Vivamus et mi at arcu mattis iaculis. Nullam posuere tristique tortor. In bibendum. Aenean ornare, nunc eget pretium porttitor, sem est pretium leo, non euismod nulla dui non diam. Pellentesque dictum faucibus leo. Vestibulum ac ante. Sed in est. Sed sodales nisl sit amet augue. Donec ultrices, augue ullamcorper posuere laoreet, turpis massa tristique justo, sed egestas metus magna sed purus. Fusce eleifend, dui ut posuere auctor, justo elit posuere sapien, at blandit enim quam fringilla mi.</p>
	        <h1>Interdum</h1>
	        <div className="descr">May 24, 2006 by Lectus</div>
	        <p>Praesent nisi sem, bibendum in, ultrices sit amet, euismod sit amet, dui. Donec varius tincidunt nisi. Ut ut sapien. Integer porta. Fusce nibh. Curabitur pellentesque, lectus at <a href="index.html">volutpat interdum</a>, sem justo placerat elit, eget feugiat est leo tempor quam. Ut quis neque convallis magna consequat molestie. Nullam semper massa eget ligula. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque a nibh quis nunc volutpat aliquam</p>
	        <code>margin-bottom: 12px;
	          font: normal 1.1em "Lucida Sans Unicode",serif;
	          background: url(img/quote.gif) no-repeat;
	          padding-left: 28px;
	          color: #555;</code>
	        <p>Eget feugiat est leo tempor quam. Ut quis neque convallis magna consequat molestie.</p>
		-*/}
		

		return (
	      <div className="content">
	       	{ this.getContents()}
	      </div>
		);
	}
});

var RightMenu = React.createClass({
	render: function(){
		 return (
	      <div>
	        <div className="sidenav">
	          <h1>FRIEND LINK</h1>
	          <ul>
	            <li><a href="index.html">pellentesque</a></li>
	            <li><a href="index.html">sociis natoque</a></li>
	            <li><a href="index.html">convallis</a></li>
	          </ul>
	          <h1>RECOMMEND LINK</h1>
	          <ul>
	            <li><a href="index.html">consequat molestie</a></li>
	            <li><a href="index.html">sem justo</a></li>
	            <li><a href="index.html">semper</a></li>
	          </ul>
	          <h1>ETC</h1>
	          <ul>
	            <li><a href="index.html">sociis natoque</a></li>
	            <li><a href="index.html">magna sed purus</a></li>
	            <li><a href="index.html">tincidunt</a></li>
	          </ul>
	        </div>
	        <div className="clearer">&nbsp;</div>
	      </div>
	    );
	}
});


ReactDOM.render(
	<div>
		<ContentFrame />
		<RightMenu />
	</div>,
	document.getElementById('main')
);