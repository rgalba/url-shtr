package me.rgalba.bb8url.config;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

/** This class is necessary to expose functions via HTTP endpoints
 *  Its fully qualified name needs to be used on AWS Lambda configuration page
 */

public class ConfigStringHandler extends SpringBootRequestHandler<String, String> {}
