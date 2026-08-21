# Effigy Distillation

A Java-based image processing experiment inspired by media transformation concepts encountered while working with **SAP Commerce (Hybris)**.

The project explores a simple but practical problem:

> Given an original product image, how can an application generate and manage alternative image representations suitable for different delivery contexts?

In enterprise commerce platforms, product media is rarely just a single uploaded image. A source asset may need to exist in multiple forms—for example:

* Product thumbnails
* Product listing images
* Product detail images
* Zoom images
* Mobile-specific representations
* Different resolutions or dimensions

**Effigy Distillation** was created as an experimental exploration of those ideas outside the SAP Commerce platform.

## Origin

The project was inspired by concepts encountered while developing solutions around **SAP Commerce product content and media management**.

Rather than modifying the Commerce platform directly, this repository isolates the image transformation problem into a smaller experimental application.

The intention was to explore questions such as:

* How should an original image be represented?
* How can derivative images be generated?
* How should resizing logic preserve aspect ratios?
* How can image-processing responsibilities be separated from application logic?
* What architectural patterns make media transformation extensible?

The result is a small technical playground for experimenting with image resizing and transformation possibilities.

## Concept

The basic processing model is:

```text
                ┌──────────────────┐
                │ Original Image   │
                └────────┬─────────┘
                         │
                         ▼
              ┌──────────────────────┐
              │ Image Processing     │
              │ / Transformation     │
              └──────────┬───────────┘
                         │
          ┌──────────────┼──────────────┐
          ▼              ▼              ▼
     Thumbnail       Medium Image      Large Image
```

An original asset can therefore act as the source from which multiple derived representations are produced.

This mirrors a common enterprise media-management pattern:

> **Original asset → transformation process → derived media formats**

## What the Project Explores

The project focuses on experimentation around:

* Image resizing
* Dimension handling
* Aspect ratio preservation
* Image transformation
* Media derivatives
* Separation of processing logic
* Java application design
* Extensible transformation workflows

The purpose is less about building a production-ready image platform and more about using a concrete problem to explore **application design and media-processing concepts**.

## Relationship to SAP Commerce

This project was inspired by experience working with SAP Commerce/Hybris, particularly the broader problem space surrounding product content and media.

It is **not an SAP Commerce extension** and does not require a SAP Commerce installation.

Instead, it represents an isolated exploration of a concept that frequently exists inside enterprise commerce environments:

```text
Product Content
      │
      ▼
 Product Media
      │
      ▼
Original Asset
      │
      ▼
Transformation / Processing
      │
      ├── Thumbnail
      ├── Listing Image
      ├── Product Detail Image
      └── Other Derived Formats
```

By extracting the problem from the larger platform, the implementation can focus on the underlying engineering questions.

## Why "Distillation"?

The name reflects the idea of taking a source asset and producing alternative representations from it.

In this context, an image is treated as a source from which more specific forms can be derived for different purposes.

For example:

```text
High Resolution Source
          │
          ▼
   ┌───────────────┐
   │ Transformation │
   └───────┬───────┘
           │
     ┌─────┴─────┐
     ▼           ▼
 Smaller      Optimised
 Variant      Variant
```

The project is therefore an experiment in **deriving useful representations from an original digital asset**.

## Architecture

The application separates the image-processing concern from the rest of the application logic.

A simplified conceptual structure is:

```text
Client / Application
        │
        ▼
Image Processing Service
        │
        ▼
Transformation Strategy
        │
        ▼
Image Manipulation
        │
        ▼
Generated Image
```

This separation allows the processing implementation to evolve independently.

Potential future transformation strategies could include:

* Fixed dimensions
* Percentage scaling
* Aspect-ratio-preserving resize
* Cropping
* Compression
* Format conversion
* Watermarking
* AI-assisted image enhancement

## Technology

The project uses Java-based technologies to explore image processing and application design.

See the project configuration and source code for the exact versions and dependencies.


## Project Status

This repository is an **experimental proof of concept**.

It was created as a technical exploration rather than a production media-management system.

Future experimentation may include:

* Additional transformation strategies
* REST-based image processing
* Persistent media storage
* Batch processing
* Asynchronous processing
* Cloud object storage
* Event-driven media processing
* AI-assisted image enrichment
* Integration with enterprise commerce platforms

## What I Learned

This project provided an opportunity to experiment with a practical engineering problem outside the boundaries of a larger enterprise platform.

The broader lesson was that platforms such as SAP Commerce expose interesting architectural problems that can be isolated and explored independently.

The value of the experiment was therefore not simply:

> “How do I resize an image?”

but rather:

> “How can a media transformation capability be designed as an independent, extensible application concern?”
