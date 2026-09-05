package com.phisher98;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/phisher98/Dooflix;", "", "id", "", "links", "", "Lcom/phisher98/DooflixLink;", "<init>", "(JLjava/util/List;)V", "getId", "()J", "getLinks", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Dooflix {
    private final long id;

    @NotNull
    private final List<DooflixLink> links;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Dooflix copy$default(Dooflix dooflix, long j, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = dooflix.id;
        }
        if ((i & 2) != 0) {
            list = dooflix.links;
        }
        return dooflix.copy(j, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    public final List<DooflixLink> component2() {
        return this.links;
    }

    @NotNull
    public final Dooflix copy(long id, @NotNull List<DooflixLink> links) {
        return new Dooflix(id, links);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Dooflix)) {
            return false;
        }
        Dooflix dooflix = (Dooflix) other;
        return this.id == dooflix.id && Intrinsics.areEqual(this.links, dooflix.links);
    }

    public int hashCode() {
        return (Dooflix$$ExternalSyntheticBackport0.m14m(this.id) * 31) + this.links.hashCode();
    }

    @NotNull
    public String toString() {
        return "Dooflix(id=" + this.id + ", links=" + this.links + ')';
    }

    public Dooflix(long id, @NotNull List<DooflixLink> list) {
        this.id = id;
        this.links = list;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final List<DooflixLink> getLinks() {
        return this.links;
    }
}
