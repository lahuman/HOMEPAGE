var Header = React.createClass({
render: function() {
return (
      <div>
        <div className="title">
          <h1>LAHUMAN</h1>
        </div>
        <div className="navigation">
          <a href="index.html">About Me</a>
          <a href="index.html">Suspendisse</a>
          <a href="index.html">Elemen</a>
          <a href="index.html">Maecenas</a>
          <a href="index.html">Sodales</a>
          <div className="clearer"><span /></div>
        </div>
      </div>
    );
}
});

ReactDOM.render(
	<Header />,
	document.getElementById('header')
);