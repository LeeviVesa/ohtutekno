import React from 'react';
import ReactDOM from 'react-dom';
import MusicPlayer from 'react-responsive-music-player'
class Player extends React.Component {
    componentDidMount(){
        fetch('http://localhost:8080/list')
            .then((response) => response.json())
            .then((responseJson) => {
                let placeholdersonglist = [];
                for(let i = 0; i <responseJson.length; i++ ){
                placeholdersonglist.push(
                    {
                        url: responseJson[i].path,
                        cover: 'vsa pieni.jpg',
                        title:  responseJson[i].songName,
                        artist: [
                            responseJson[i].artistName,
                        ]
                    }
                )
                }
                this.setState({playlist: placeholdersonglist});

            });
    }

    constructor(props) {
        super(props);
        this.state = {
            playlist:[
                {
                    url: 'path/to/mp3',
                    cover: 'https://www.meme-arsenal.com/memes/5b2cdc7eac6b7ae637f72ee3f3709076.jpg',
                    title: 'Despacito',
                    artist: [
                        'Luis Fonsi',
                        'Daddy Yankee'
                    ]
                },
                {
                    url: 'path/to/mp3',
                    cover: '../img/vsa pieni.png',
                    title: 'Bedtime Stories',
                    artist: [
                        'Jay Chou'
                    ]
                }
            ]

        };
    }

    render() {

        return (
            <div>
                <img style={{height:100,  alignItems:"center"}} src={require('../img/vsa pieni.png')} />
                <text style={{marginTop: 200, fontSize: 60, color:"#c8c8c8"}}>SONGS</text>
                <div style={{width: 900}}>
            <div style={{marginTop: 150, border: '5px solid grey', borderRightColor: 'grey',}} >
                <MusicPlayer btnColor = "#0080a0" progressColor ="#0080a0"
                             style={{backgroundColor: "#ebe9ef", margintop: 150, fontSize: 20}} playlist={this.state.playlist} />
            </div>
            </div>
            </div>
        );
    }

}
ReactDOM.render(<Player/>, document.getElementById('root') );