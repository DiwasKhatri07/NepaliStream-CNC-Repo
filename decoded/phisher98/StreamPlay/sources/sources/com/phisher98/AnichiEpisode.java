package com.phisher98;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/phisher98/AnichiEpisode;", "", "sourceUrls", "", "Lcom/phisher98/SourceUrl;", "<init>", "(Ljava/util/List;)V", "getSourceUrls", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AnichiEpisode {

    @NotNull
    private final List<SourceUrl> sourceUrls;

    /* JADX WARN: Illegal instructions before constructor call */
    public AnichiEpisode() {
        List list = null;
        this(list, 1, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnichiEpisode copy$default(AnichiEpisode anichiEpisode, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = anichiEpisode.sourceUrls;
        }
        return anichiEpisode.copy(list);
    }

    @NotNull
    public final List<SourceUrl> component1() {
        return this.sourceUrls;
    }

    @NotNull
    public final AnichiEpisode copy(@NotNull List<SourceUrl> sourceUrls) {
        return new AnichiEpisode(sourceUrls);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AnichiEpisode) && Intrinsics.areEqual(this.sourceUrls, ((AnichiEpisode) other).sourceUrls);
    }

    public int hashCode() {
        return this.sourceUrls.hashCode();
    }

    @NotNull
    public String toString() {
        return "AnichiEpisode(sourceUrls=" + this.sourceUrls + ')';
    }

    public AnichiEpisode(@NotNull List<SourceUrl> list) {
        this.sourceUrls = list;
    }

    public /* synthetic */ AnichiEpisode(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    @NotNull
    public final List<SourceUrl> getSourceUrls() {
        return this.sourceUrls;
    }
}
