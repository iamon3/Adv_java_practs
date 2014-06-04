package com.annotations.eg1;

/* 
 * Refer : http://www.journaldev.com/721/java-annotations-tutorial-with-custom-annotation-example-and-parsing-using-reflection
 */
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation methods can’t have parameters.
 * Annotation methods return types are limited to primitives, String, Enums, Annotation or array of these.
 * Annotation methods can have default values.
 * Annotations can have meta annotations attached to them. Meta annotations are used to provide information about the annotation. 
 * There are four types of meta annotations : @Document, @Target, @Inherited, @Retention
 */

// @Documented : Indicates that elements using this annotation should be documented by java doc and similar tools. 
// This type should be used to annotate the declarations of types whose annotations affect the use of annotated elements by their clients. 
// If a type declaration is annotated with Documented, its annotations become part of the public API of the annotated elements.
@Documented

// @Target : Indicates the kinds of program element to which an annotation type is applicable. 
// Some possible values are TYPE, METHOD, CONSTRUCTOR, FIELD etc. 
// If Target meta-annotation is not present, then annotation can be used on any program element.
@Target(ElementType.METHOD)

// @Inherited : Indicates that an annotation type is automatically inherited. 
// If user queries the annotation type on a class declaration, and the class declaration has no annotation for this type, 
// then the class’s superclass will automatically be queried for the annotation type. 
// This process will be repeated until an annotation for this type is found, or the top of the class hierarchy (Object) is reached.
@Inherited

// @Retention : Indicates how long annotations with the annotated type are to be retained. 
// It takes RetentionPolicy argument whose Possible values are 
// SOURCE - This annotation will be removed at compile time and will not be available at compiled class.  
// CLASS -  This annotation will be compiled and included in the class file.
// RUNTIME - This annotation will be available in JVM at runtime
@Retention(RetentionPolicy.RUNTIME)

// Creating custom annotation is similar to writing an interface, except that it interface keyword is prefixed with @ symbol.
public @interface MethodInfo{
	String author() default "Free";
	String date();
	int revision() default 1;
	String comments();
}