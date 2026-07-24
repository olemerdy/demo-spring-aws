package org.lafeuille.demo.infra.localstack

object LocalStackDefaults {
    const val VERSION = "4.4.0" // Latest version without the auth token requirement
    const val DOCKER_IMAGE_NAME = "localstack/localstack:$VERSION"
}
