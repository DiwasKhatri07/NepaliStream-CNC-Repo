package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SuperStreamParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/SuperStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/phisher98/Link;", "", "url", "", "quality", "name", "size", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getQuality", "getName", "getSize", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Link {

    @Nullable
    private final String name;

    @Nullable
    private final String quality;

    @Nullable
    private final String size;

    @Nullable
    private final String url;

    public static /* synthetic */ Link copy$default(Link link, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = link.url;
        }
        if ((i & 2) != 0) {
            str2 = link.quality;
        }
        if ((i & 4) != 0) {
            str3 = link.name;
        }
        if ((i & 8) != 0) {
            str4 = link.size;
        }
        return link.copy(str, str2, str3, str4);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getQuality() {
        return this.quality;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSize() {
        return this.size;
    }

    @NotNull
    public final Link copy(@Nullable String url, @Nullable String quality, @Nullable String name, @Nullable String size) {
        return new Link(url, quality, name, size);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Link)) {
            return false;
        }
        Link link = (Link) other;
        return Intrinsics.areEqual(this.url, link.url) && Intrinsics.areEqual(this.quality, link.quality) && Intrinsics.areEqual(this.name, link.name) && Intrinsics.areEqual(this.size, link.size);
    }

    public int hashCode() {
        return ((((((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.quality == null ? 0 : this.quality.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.size != null ? this.size.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Link(url=" + this.url + ", quality=" + this.quality + ", name=" + this.name + ", size=" + this.size + ')';
    }

    public Link(@Nullable String url, @Nullable String quality, @Nullable String name, @Nullable String size) {
        this.url = url;
        this.quality = quality;
        this.name = name;
        this.size = size;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final String getQuality() {
        return this.quality;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getSize() {
        return this.size;
    }
}
