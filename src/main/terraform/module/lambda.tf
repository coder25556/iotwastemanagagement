locals {
  function_name = iot_waste_production_lambda
  handler =  "io.quarkus.amazon.lambda.runtime.QuarkusStreamHandler"


}

resource "aws_lambda_function" "test_lambda" {
  filename      = "lambda_function_payload.zip"
  function_name = local.function_name
  role          = aws_iam_role.iam_for_lambda.arn
  handler       = local.handler

  source_code_hash = data.archive_file.lambda.output_base64sha256

  runtime = "nodejs18.x"

  environment {
    variables = {
      foo = "bar"
    }
  }
}