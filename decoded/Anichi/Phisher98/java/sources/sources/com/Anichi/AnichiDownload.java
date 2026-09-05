package com.Anichi;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnichiParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Anichi/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/Anichi/AnichiDownload;", "", "links", "", "Lcom/Anichi/AnichiDownloadLink;", "<init>", "(Ljava/util/List;)V", "getLinks", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AnichiDownload {

    @NotNull
    private final List<AnichiDownloadLink> links;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnichiDownload copy$default(AnichiDownload anichiDownload, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = anichiDownload.links;
        }
        return anichiDownload.copy(list);
    }

    @NotNull
    public final List<AnichiDownloadLink> component1() {
        return this.links;
    }

    @NotNull
    public final AnichiDownload copy(@NotNull List<AnichiDownloadLink> links) {
        return new AnichiDownload(links);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AnichiDownload) && Intrinsics.areEqual(this.links, ((AnichiDownload) other).links);
    }

    public int hashCode() {
        return this.links.hashCode();
    }

    @NotNull
    public String toString() {
        return "AnichiDownload(links=" + this.links + ')';
    }

    public AnichiDownload(@NotNull List<AnichiDownloadLink> list) {
        this.links = list;
    }

    @NotNull
    public final List<AnichiDownloadLink> getLinks() {
        return this.links;
    }
}
