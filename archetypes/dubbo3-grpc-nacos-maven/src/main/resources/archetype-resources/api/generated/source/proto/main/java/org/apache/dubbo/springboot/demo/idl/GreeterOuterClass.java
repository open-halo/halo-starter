#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: greeter.proto

package org.apache.dubbo.springboot.demo.idl;

public final class GreeterOuterClass {
  private GreeterOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_apache_dubbo_springboot_demo_idl_GreeterRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_apache_dubbo_springboot_demo_idl_GreeterRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_apache_dubbo_springboot_demo_idl_GreeterReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_apache_dubbo_springboot_demo_idl_GreeterReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "${symbol_escape}n${symbol_escape}rgreeter.proto${symbol_escape}022${symbol_dollar}org.apache.dubbo.spring" +
      "boot.demo.idl${symbol_escape}"${symbol_escape}036${symbol_escape}n${symbol_escape}016GreeterRequest${symbol_escape}022${symbol_escape}014${symbol_escape}n${symbol_escape}004name${symbol_escape}030" +
      "${symbol_escape}001 ${symbol_escape}001(${symbol_escape}t${symbol_escape}"${symbol_escape}037${symbol_escape}n${symbol_escape}014GreeterReply${symbol_escape}022${symbol_escape}017${symbol_escape}n${symbol_escape}007message${symbol_escape}030${symbol_escape}001 ${symbol_escape}001(${symbol_escape}t2|" +
      "${symbol_escape}n${symbol_escape}007Greeter${symbol_escape}022q${symbol_escape}n${symbol_escape}005greet${symbol_escape}0224.org.apache.dubbo.sp" +
      "ringboot.demo.idl.GreeterRequest${symbol_escape}0322.org.a" +
      "pache.dubbo.springboot.demo.idl.GreeterR" +
      "eplyB${symbol_escape}002P${symbol_escape}001b${symbol_escape}006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_org_apache_dubbo_springboot_demo_idl_GreeterRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_org_apache_dubbo_springboot_demo_idl_GreeterRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_apache_dubbo_springboot_demo_idl_GreeterRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_org_apache_dubbo_springboot_demo_idl_GreeterReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_org_apache_dubbo_springboot_demo_idl_GreeterReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_apache_dubbo_springboot_demo_idl_GreeterReply_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
