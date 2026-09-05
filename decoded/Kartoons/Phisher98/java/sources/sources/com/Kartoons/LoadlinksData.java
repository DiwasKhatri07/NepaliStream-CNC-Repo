package com.Kartoons;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KartoonsParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Kartoons/classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0006HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/Kartoons/LoadlinksData;", "", "links", "", "Lcom/Kartoons/Link;", "title", "", "id", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getLinks", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "getId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class LoadlinksData {

    @Nullable
    private final String id;

    @Nullable
    private final List<Link> links;

    @Nullable
    private final String title;

    public LoadlinksData() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LoadlinksData copy$default(LoadlinksData loadlinksData, List list, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = loadlinksData.links;
        }
        if ((i & 2) != 0) {
            str = loadlinksData.title;
        }
        if ((i & 4) != 0) {
            str2 = loadlinksData.id;
        }
        return loadlinksData.copy(list, str, str2);
    }

    @Nullable
    public final List<Link> component1() {
        return this.links;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final LoadlinksData copy(@Nullable List<Link> links, @Nullable String title, @Nullable String id) {
        return new LoadlinksData(links, title, id);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadlinksData)) {
            return false;
        }
        LoadlinksData loadlinksData = (LoadlinksData) other;
        return Intrinsics.areEqual(this.links, loadlinksData.links) && Intrinsics.areEqual(this.title, loadlinksData.title) && Intrinsics.areEqual(this.id, loadlinksData.id);
    }

    public int hashCode() {
        return ((((this.links == null ? 0 : this.links.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.id != null ? this.id.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LoadlinksData(links=" + this.links + ", title=" + this.title + ", id=" + this.id + ')';
    }

    public LoadlinksData(@Nullable List<Link> list, @Nullable String title, @Nullable String id) {
        this.links = list;
        this.title = title;
        this.id = id;
    }

    public /* synthetic */ LoadlinksData(List list, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }

    @Nullable
    public final List<Link> getLinks() {
        return this.links;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }
}
