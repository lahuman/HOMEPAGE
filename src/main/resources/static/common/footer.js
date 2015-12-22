var Footer = React.createClass({
	render: function(){
		 return (
	      <div>
	        <div className="left">© 2013 <a href="index.html">Website.com</a>. Valid <a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a> &amp; <a href="http://validator.w3.org/check?uri=referer">XHTML</a>.</div>
	        <div className="right"><a href="http://templates.arcsin.se/">Website template</a> by <a href="http://arcsin.se/">Arcsin</a></div>
	        <div className="clearer">&nbsp;</div>
	      </div>
	    );
	}
});

ReactDOM.render(
	<Footer />,
	document.getElementById('footer')
);