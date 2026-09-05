package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001(B\u0089\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0090\u0001\u0010!\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\rHÆ\u0001¢\u0006\u0002\u0010\"J\u0014\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010&\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010'\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lcom/phisher98/ExternalResponse;", "", "code", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "msg", "", "serverRuntime", "", "server_runtime", "serverName", "server_name", "data", "Lcom/phisher98/ExternalResponse$Data;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Lcom/phisher98/ExternalResponse$Data;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMsg", "()Ljava/lang/String;", "getServerRuntime", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getServerName", "getData", "()Lcom/phisher98/ExternalResponse$Data;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Lcom/phisher98/ExternalResponse$Data;)Lcom/phisher98/ExternalResponse;", "equals", "", "other", "hashCode", "toString", "Data", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ExternalResponse {

    @Nullable
    private final Integer code;

    @Nullable
    private final Data data;

    @Nullable
    private final String msg;

    @Nullable
    private final String serverName;

    @Nullable
    private final Double serverRuntime;

    public ExternalResponse() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ExternalResponse copy$default(ExternalResponse externalResponse, Integer num, String str, Double d, String str2, Data data, int i, Object obj) {
        if ((i & 1) != 0) {
            num = externalResponse.code;
        }
        if ((i & 2) != 0) {
            str = externalResponse.msg;
        }
        if ((i & 4) != 0) {
            d = externalResponse.serverRuntime;
        }
        if ((i & 8) != 0) {
            str2 = externalResponse.serverName;
        }
        if ((i & 16) != 0) {
            data = externalResponse.data;
        }
        Data data2 = data;
        Double d2 = d;
        return externalResponse.copy(num, str, d2, str2, data2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Double getServerRuntime() {
        return this.serverRuntime;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getServerName() {
        return this.serverName;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Data getData() {
        return this.data;
    }

    @NotNull
    public final ExternalResponse copy(@JsonProperty("code") @Nullable Integer code, @JsonProperty("msg") @Nullable String msg, @JsonProperty("server_runtime") @Nullable Double serverRuntime, @JsonProperty("server_name") @Nullable String serverName, @JsonProperty("data") @Nullable Data data) {
        return new ExternalResponse(code, msg, serverRuntime, serverName, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExternalResponse)) {
            return false;
        }
        ExternalResponse externalResponse = (ExternalResponse) other;
        return Intrinsics.areEqual(this.code, externalResponse.code) && Intrinsics.areEqual(this.msg, externalResponse.msg) && Intrinsics.areEqual(this.serverRuntime, externalResponse.serverRuntime) && Intrinsics.areEqual(this.serverName, externalResponse.serverName) && Intrinsics.areEqual(this.data, externalResponse.data);
    }

    public int hashCode() {
        return ((((((((this.code == null ? 0 : this.code.hashCode()) * 31) + (this.msg == null ? 0 : this.msg.hashCode())) * 31) + (this.serverRuntime == null ? 0 : this.serverRuntime.hashCode())) * 31) + (this.serverName == null ? 0 : this.serverName.hashCode())) * 31) + (this.data != null ? this.data.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ExternalResponse(code=" + this.code + ", msg=" + this.msg + ", serverRuntime=" + this.serverRuntime + ", serverName=" + this.serverName + ", data=" + this.data + ')';
    }

    public ExternalResponse(@JsonProperty("code") @Nullable Integer code, @JsonProperty("msg") @Nullable String msg, @JsonProperty("server_runtime") @Nullable Double serverRuntime, @JsonProperty("server_name") @Nullable String serverName, @JsonProperty("data") @Nullable Data data) {
        this.code = code;
        this.msg = msg;
        this.serverRuntime = serverRuntime;
        this.serverName = serverName;
        this.data = data;
    }

    public /* synthetic */ ExternalResponse(Integer num, String str, Double d, String str2, Data data, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : d, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : data);
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    public final Double getServerRuntime() {
        return this.serverRuntime;
    }

    @Nullable
    public final String getServerName() {
        return this.serverName;
    }

    @Nullable
    public final Data getData() {
        return this.data;
    }

    /* JADX INFO: compiled from: StreamPlayParser.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0019BA\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u001e\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003JC\u0010\u0012\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u001e\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\tHÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/phisher98/ExternalResponse$Data;", "", "link", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "fileList", "", "Lcom/phisher98/ExternalResponse$Data$FileList;", "file_list", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getLink", "()Ljava/lang/String;", "getFileList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "FileList", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Data {

        @Nullable
        private final List<FileList> fileList;

        @Nullable
        private final String link;

        /* JADX WARN: Multi-variable type inference failed */
        public Data() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Data copy$default(Data data, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = data.link;
            }
            if ((i & 2) != 0) {
                list = data.fileList;
            }
            return data.copy(str, list);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLink() {
            return this.link;
        }

        @Nullable
        public final List<FileList> component2() {
            return this.fileList;
        }

        @NotNull
        public final Data copy(@JsonProperty("link") @Nullable String link, @JsonProperty("file_list") @Nullable List<FileList> fileList) {
            return new Data(link, fileList);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data)) {
                return false;
            }
            Data data = (Data) other;
            return Intrinsics.areEqual(this.link, data.link) && Intrinsics.areEqual(this.fileList, data.fileList);
        }

        public int hashCode() {
            return ((this.link == null ? 0 : this.link.hashCode()) * 31) + (this.fileList != null ? this.fileList.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Data(link=" + this.link + ", fileList=" + this.fileList + ')';
        }

        public Data(@JsonProperty("link") @Nullable String link, @JsonProperty("file_list") @Nullable List<FileList> list) {
            this.link = link;
            this.fileList = list;
        }

        public /* synthetic */ Data(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list);
        }

        @Nullable
        public final String getLink() {
            return this.link;
        }

        @Nullable
        public final List<FileList> getFileList() {
            return this.fileList;
        }

        /* JADX INFO: compiled from: StreamPlayParser.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\\\u0010\u0016\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\nHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/phisher98/ExternalResponse$Data$FileList;", "", "fid", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "fileName", "", "file_name", "ossFid", "oss_fid", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)V", "getFid", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFileName", "()Ljava/lang/String;", "getOssFid", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)Lcom/phisher98/ExternalResponse$Data$FileList;", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class FileList {

            @Nullable
            private final Long fid;

            @Nullable
            private final String fileName;

            @Nullable
            private final Long ossFid;

            public FileList() {
                this(null, null, null, 7, null);
            }

            public static /* synthetic */ FileList copy$default(FileList fileList, Long l, String str, Long l2, int i, Object obj) {
                if ((i & 1) != 0) {
                    l = fileList.fid;
                }
                if ((i & 2) != 0) {
                    str = fileList.fileName;
                }
                if ((i & 4) != 0) {
                    l2 = fileList.ossFid;
                }
                return fileList.copy(l, str, l2);
            }

            @Nullable
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Long getFid() {
                return this.fid;
            }

            @Nullable
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getFileName() {
                return this.fileName;
            }

            @Nullable
            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Long getOssFid() {
                return this.ossFid;
            }

            @NotNull
            public final FileList copy(@JsonProperty("fid") @Nullable Long fid, @JsonProperty("file_name") @Nullable String fileName, @JsonProperty("oss_fid") @Nullable Long ossFid) {
                return new FileList(fid, fileName, ossFid);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FileList)) {
                    return false;
                }
                FileList fileList = (FileList) other;
                return Intrinsics.areEqual(this.fid, fileList.fid) && Intrinsics.areEqual(this.fileName, fileList.fileName) && Intrinsics.areEqual(this.ossFid, fileList.ossFid);
            }

            public int hashCode() {
                return ((((this.fid == null ? 0 : this.fid.hashCode()) * 31) + (this.fileName == null ? 0 : this.fileName.hashCode())) * 31) + (this.ossFid != null ? this.ossFid.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "FileList(fid=" + this.fid + ", fileName=" + this.fileName + ", ossFid=" + this.ossFid + ')';
            }

            public FileList(@JsonProperty("fid") @Nullable Long fid, @JsonProperty("file_name") @Nullable String fileName, @JsonProperty("oss_fid") @Nullable Long ossFid) {
                this.fid = fid;
                this.fileName = fileName;
                this.ossFid = ossFid;
            }

            public /* synthetic */ FileList(Long l, String str, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : l2);
            }

            @Nullable
            public final Long getFid() {
                return this.fid;
            }

            @Nullable
            public final String getFileName() {
                return this.fileName;
            }

            @Nullable
            public final Long getOssFid() {
                return this.ossFid;
            }
        }
    }
}
