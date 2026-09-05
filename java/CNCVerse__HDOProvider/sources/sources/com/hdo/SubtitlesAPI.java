package com.hdo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SubUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/HDOProvider/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0001\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hdo/SubtitlesAPI;", "", "subtitles", "", "Lcom/hdo/SubtitleItem;", "<init>", "(Ljava/util/List;)V", "getSubtitles", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "HDOProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SubtitlesAPI {

    @JsonProperty("subtitles")
    @Nullable
    private final List<SubtitleItem> subtitles;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubtitlesAPI copy$default(SubtitlesAPI subtitlesAPI, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = subtitlesAPI.subtitles;
        }
        return subtitlesAPI.copy(list);
    }

    @Nullable
    public final List<SubtitleItem> component1() {
        return this.subtitles;
    }

    @NotNull
    public final SubtitlesAPI copy(@JsonProperty("subtitles") @Nullable List<SubtitleItem> subtitles) {
        return new SubtitlesAPI(subtitles);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SubtitlesAPI) && Intrinsics.areEqual(this.subtitles, ((SubtitlesAPI) other).subtitles);
    }

    public int hashCode() {
        if (this.subtitles == null) {
            return 0;
        }
        return this.subtitles.hashCode();
    }

    @NotNull
    public String toString() {
        return "SubtitlesAPI(subtitles=" + this.subtitles + ')';
    }

    public SubtitlesAPI(@JsonProperty("subtitles") @Nullable List<SubtitleItem> list) {
        this.subtitles = list;
    }

    @Nullable
    public final List<SubtitleItem> getSubtitles() {
        return this.subtitles;
    }
}
