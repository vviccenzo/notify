package com.api.emailNotify.infrastructure.template;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EmailTemplate {

	/**
	 * Gera um template de e-mail HTML para Gmail.
	 *
	 * @param title o título do e-mail
	 * @param body  o texto do corpo do e-mail
	 * @return o template HTML com os valores substituídos
	 */
	public static String generateEmailTemplate(String title, String body) {
		return """
				<!DOCTYPE html>
				<html>
				<head>
				    <meta charset="UTF-8">
				    <meta name="viewport" content="width=device-width, initial-scale=1.0">
				    <title>Email</title>
				    <style>
				        body {
				            font-family: Arial, sans-serif;
				            margin: 0;
				            padding: 0;
				            background-color: #f4f4f4;
				            color: #333;
				        }
				        .container {
				            max-width: 600px;
				            margin: 20px auto;
				            background: #fff;
				            padding: 20px;
				            border-radius: 8px;
				            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
				        }
				        h1 {
				            color: #444;
				        }
				        p {
				            line-height: 1.6;
				        }
				        .footer {
				            margin-top: 20px;
				            text-align: center;
				            font-size: 0.9em;
				            color: #666;
				        }
				    </style>
				</head>
				<body>
				    <div class="container">
				        <h1>%s</h1>
				        <p>%s</p>
				        <div class="footer">
				            <p>Este é um e-mail automático. Por favor, não responda.</p>
				        </div>
				    </div>
				</body>
				</html>
				""".formatted(title, body);
	}

}
