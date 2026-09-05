package com.phisher98;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/phisher98/TorrentioResponse;", "", "streams", "", "Lcom/phisher98/TorrentioStream;", "<init>", "(Ljava/util/List;)V", "getStreams", "()Ljava/util/List;", "Lcom/google/gson/annotations/SerializedName;", "value", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class TorrentioResponse {

    @SerializedName("streams")
    @NotNull
    private final List<TorrentioStream> streams;

    /* JADX WARN: Illegal instructions before constructor call */
    public TorrentioResponse() {
        List list = null;
        this(list, 1, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TorrentioResponse copy$default(TorrentioResponse torrentioResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = torrentioResponse.streams;
        }
        return torrentioResponse.copy(list);
    }

    @NotNull
    public final List<TorrentioStream> component1() {
        return this.streams;
    }

    @NotNull
    public final TorrentioResponse copy(@NotNull List<TorrentioStream> streams) {
        return new TorrentioResponse(streams);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TorrentioResponse) && Intrinsics.areEqual(this.streams, ((TorrentioResponse) other).streams);
    }

    public int hashCode() {
        return this.streams.hashCode();
    }

    @NotNull
    public String toString() {
        return "TorrentioResponse(streams=" + this.streams + ')';
    }

    public TorrentioResponse(@NotNull List<TorrentioStream> list) {
        this.streams = list;
    }

    public /* synthetic */ TorrentioResponse(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    @NotNull
    public final List<TorrentioStream> getStreams() {
        return this.streams;
    }
}
