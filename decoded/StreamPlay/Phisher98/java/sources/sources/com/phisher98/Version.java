package com.phisher98;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/phisher98/Version;", "", "name", "", "links", "", "Lcom/phisher98/Link;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getLinks", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Version {

    @Nullable
    private final List<Link> links;

    @Nullable
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Version copy$default(Version version, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = version.name;
        }
        if ((i & 2) != 0) {
            list = version.links;
        }
        return version.copy(str, list);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final List<Link> component2() {
        return this.links;
    }

    @NotNull
    public final Version copy(@Nullable String name, @Nullable List<Link> links) {
        return new Version(name, links);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Version)) {
            return false;
        }
        Version version = (Version) other;
        return Intrinsics.areEqual(this.name, version.name) && Intrinsics.areEqual(this.links, version.links);
    }

    public int hashCode() {
        return ((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.links != null ? this.links.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Version(name=" + this.name + ", links=" + this.links + ')';
    }

    public Version(@Nullable String name, @Nullable List<Link> list) {
        this.name = name;
        this.links = list;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final List<Link> getLinks() {
        return this.links;
    }
}
