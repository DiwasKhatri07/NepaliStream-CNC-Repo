package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SuperStreamParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/SuperStream/classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u001e\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003JC\u0010\u0012\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u001e\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\tHÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/phisher98/DData;", "", "link", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "fileList", "", "Lcom/phisher98/FileList;", "file_list", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getLink", "()Ljava/lang/String;", "getFileList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class DData {

    @Nullable
    private final List<FileList> fileList;

    @Nullable
    private final String link;

    /* JADX WARN: Multi-variable type inference failed */
    public DData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DData copy$default(DData dData, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dData.link;
        }
        if ((i & 2) != 0) {
            list = dData.fileList;
        }
        return dData.copy(str, list);
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
    public final DData copy(@JsonProperty("link") @Nullable String link, @JsonProperty("file_list") @Nullable List<FileList> fileList) {
        return new DData(link, fileList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DData)) {
            return false;
        }
        DData dData = (DData) other;
        return Intrinsics.areEqual(this.link, dData.link) && Intrinsics.areEqual(this.fileList, dData.fileList);
    }

    public int hashCode() {
        return ((this.link == null ? 0 : this.link.hashCode()) * 31) + (this.fileList != null ? this.fileList.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "DData(link=" + this.link + ", fileList=" + this.fileList + ')';
    }

    public DData(@JsonProperty("link") @Nullable String link, @JsonProperty("file_list") @Nullable List<FileList> list) {
        this.link = link;
        this.fileList = list;
    }

    public /* synthetic */ DData(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
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
}
