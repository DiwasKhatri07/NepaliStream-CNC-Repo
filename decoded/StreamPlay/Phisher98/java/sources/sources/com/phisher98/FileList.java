package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\\\u0010\u0016\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\nHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/phisher98/FileList;", "", "fid", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "fileName", "", "file_name", "ossFid", "oss_fid", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)V", "getFid", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFileName", "()Ljava/lang/String;", "getOssFid", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)Lcom/phisher98/FileList;", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class FileList {

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
