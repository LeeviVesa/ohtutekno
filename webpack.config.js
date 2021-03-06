var path = require('path');
module.exports = {
    entry: './src/main/resources/static/App.js',
    output: {
        path: path.join(__dirname, './src/main/resources/static'),
        filename: 'bundle.js',
        publicPath: '/'
    },
    module: {
        rules: [
            {
                test: /.js$/,
                loaders: 'babel-loader',
                exclude: /(node_modules)/,
                query: {
                    presets: ['es2015', 'react']
                }

            },
            {
                test:/\.css$/,
                use:['style-loader','css-loader']
            },
            {
                test: /\.(jpe?g|png|gif|svg)$/i,
                use: [
                    'url-loader?limit=10000',
                    'img-loader'
                ]
            },

        ]

    }
};
module.exports = {
    entry: './src/main/resources/static/Player.js',
    output: {
        path: path.join(__dirname, './src/main/resources/static'),
        filename: 'bundle2.js',
        publicPath: '/'
    },
    module: {
        rules: [
            {
                test: /.js$/,
                loaders: 'babel-loader',
                exclude: /(node_modules)/,
                query: {
                    presets: ['es2015', 'react']
                }

            },
            {
                test:/\.css$/,
                use:['style-loader','css-loader'],
            },
            {
                test: /\.(jpe?g|png|gif|svg)$/i,
                use: [
                    'url-loader?limit=10000',
                    'img-loader'
                ]
            },
            {
                test: /\.(jpe|jpg|woff|woff2|eot|ttf|svg)(\?.*$|$)/,
                use: [
                    'file-loader',
                ]
            },
        ]

    }
};