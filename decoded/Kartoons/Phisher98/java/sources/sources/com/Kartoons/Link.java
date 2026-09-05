package com.Kartoons;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KartoonsParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Kartoons/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011JF\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0014\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR%\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0007z\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Lcom/Kartoons/Link;", "", "name", "", "url", "subtitles", "", "linkIndex", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;)V", "getName", "()Ljava/lang/String;", "getUrl", "getSubtitles", "()Ljava/util/List;", "getLinkIndex", "()Ljava/lang/Long;", "Ljava/lang/Long;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "_link_index", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;)Lcom/Kartoons/Link;", "equals", "", "other", "hashCode", "", "toString", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Link {

    @Nullable
    private final Long linkIndex;

    @Nullable
    private final String name;

    @Nullable
    private final List<Object> subtitles;

    @Nullable
    private final String url;

    public Link() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Link copy$default(Link link, String str, String str2, List list, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = link.name;
        }
        if ((i & 2) != 0) {
            str2 = link.url;
        }
        if ((i & 4) != 0) {
            list = link.subtitles;
        }
        if ((i & 8) != 0) {
            l = link.linkIndex;
        }
        return link.copy(str, str2, list, l);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final List<Object> component3() {
        return this.subtitles;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getLinkIndex() {
        return this.linkIndex;
    }

    @NotNull
    public final Link copy(@Nullable String name, @Nullable String url, @Nullable List<? extends Object> subtitles, @Nullable Long linkIndex) {
        return new Link(name, url, subtitles, linkIndex);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Link)) {
            return false;
        }
        Link link = (Link) other;
        return Intrinsics.areEqual(this.name, link.name) && Intrinsics.areEqual(this.url, link.url) && Intrinsics.areEqual(this.subtitles, link.subtitles) && Intrinsics.areEqual(this.linkIndex, link.linkIndex);
    }

    public int hashCode() {
        return ((((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.subtitles == null ? 0 : this.subtitles.hashCode())) * 31) + (this.linkIndex != null ? this.linkIndex.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Link(name=" + this.name + ", url=" + this.url + ", subtitles=" + this.subtitles + ", linkIndex=" + this.linkIndex + ')';
    }

    public Link(@Nullable String name, @Nullable String url, @Nullable List<? extends Object> list, @Nullable Long linkIndex) {
        this.name = name;
        this.url = url;
        this.subtitles = list;
        this.linkIndex = linkIndex;
    }

    public /* synthetic */ Link(String str, String str2, List list, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : l);
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final List<Object> getSubtitles() {
        return this.subtitles;
    }

    @JsonProperty("_link_index")
    @Nullable
    public final Long getLinkIndex() {
        return this.linkIndex;
    }
}
