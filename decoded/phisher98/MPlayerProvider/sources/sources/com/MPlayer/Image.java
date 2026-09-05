package com.MPlayer;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/MPlayerProvider/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bí\u0001\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0001\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0001:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0001:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0018\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0001:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0018\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0001:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0018\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014\u0012\u0018\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jï\u0001\u0010-\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0001:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0001:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0001:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0001:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0018\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00142\u0018\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016HÆ\u0001J\u0014\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00101\u001a\u000202HÖ\u0081\u0004J\n\u00103\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001a¨\u00064"}, d2 = {"Lcom/MPlayer/Image;", "", "n16x9", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "16x9", "n2x3", "2x3", "n1x1", "1x1", "n18x14", "18x14", "n40x13", "40x13", "n9x16", "9x16", "n13x15", "13x15", "n2x1", "2x1", "n9x19", "9x19", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V", "getN16x9", "()Ljava/lang/String;", "getN2x3", "getN1x1", "getN18x14", "()Ljava/lang/Object;", "getN40x13", "getN9x16", "getN13x15", "getN2x1", "getN9x19", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "MPlayerProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Image {

    @Nullable
    private final Object n13x15;

    @NotNull
    private final String n16x9;

    @Nullable
    private final Object n18x14;

    @Nullable
    private final String n1x1;

    @Nullable
    private final String n2x1;

    @NotNull
    private final String n2x3;

    @Nullable
    private final Object n40x13;

    @Nullable
    private final Object n9x16;

    @Nullable
    private final String n9x19;

    public static /* synthetic */ Image copy$default(Image image, String str, String str2, String str3, Object obj, Object obj2, Object obj3, Object obj4, String str4, String str5, int i, Object obj5) {
        if ((i & 1) != 0) {
            str = image.n16x9;
        }
        if ((i & 2) != 0) {
            str2 = image.n2x3;
        }
        if ((i & 4) != 0) {
            str3 = image.n1x1;
        }
        if ((i & 8) != 0) {
            obj = image.n18x14;
        }
        if ((i & 16) != 0) {
            obj2 = image.n40x13;
        }
        if ((i & 32) != 0) {
            obj3 = image.n9x16;
        }
        if ((i & 64) != 0) {
            obj4 = image.n13x15;
        }
        if ((i & 128) != 0) {
            str4 = image.n2x1;
        }
        if ((i & 256) != 0) {
            str5 = image.n9x19;
        }
        String str6 = str4;
        String str7 = str5;
        Object obj6 = obj3;
        Object obj7 = obj4;
        Object obj8 = obj2;
        String str8 = str3;
        return image.copy(str, str2, str8, obj, obj8, obj6, obj7, str6, str7);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getN16x9() {
        return this.n16x9;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getN2x3() {
        return this.n2x3;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getN1x1() {
        return this.n1x1;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Object getN18x14() {
        return this.n18x14;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Object getN40x13() {
        return this.n40x13;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Object getN9x16() {
        return this.n9x16;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Object getN13x15() {
        return this.n13x15;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getN2x1() {
        return this.n2x1;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getN9x19() {
        return this.n9x19;
    }

    @NotNull
    public final Image copy(@JsonProperty("16x9") @NotNull String n16x9, @JsonProperty("2x3") @NotNull String n2x3, @JsonProperty("1x1") @Nullable String n1x1, @JsonProperty("18x14") @Nullable Object n18x14, @JsonProperty("40x13") @Nullable Object n40x13, @JsonProperty("9x16") @Nullable Object n9x16, @JsonProperty("13x15") @Nullable Object n13x15, @JsonProperty("2x1") @Nullable String n2x1, @JsonProperty("9x19") @Nullable String n9x19) {
        return new Image(n16x9, n2x3, n1x1, n18x14, n40x13, n9x16, n13x15, n2x1, n9x19);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Image)) {
            return false;
        }
        Image image = (Image) other;
        return Intrinsics.areEqual(this.n16x9, image.n16x9) && Intrinsics.areEqual(this.n2x3, image.n2x3) && Intrinsics.areEqual(this.n1x1, image.n1x1) && Intrinsics.areEqual(this.n18x14, image.n18x14) && Intrinsics.areEqual(this.n40x13, image.n40x13) && Intrinsics.areEqual(this.n9x16, image.n9x16) && Intrinsics.areEqual(this.n13x15, image.n13x15) && Intrinsics.areEqual(this.n2x1, image.n2x1) && Intrinsics.areEqual(this.n9x19, image.n9x19);
    }

    public int hashCode() {
        return (((((((((((((((this.n16x9.hashCode() * 31) + this.n2x3.hashCode()) * 31) + (this.n1x1 == null ? 0 : this.n1x1.hashCode())) * 31) + (this.n18x14 == null ? 0 : this.n18x14.hashCode())) * 31) + (this.n40x13 == null ? 0 : this.n40x13.hashCode())) * 31) + (this.n9x16 == null ? 0 : this.n9x16.hashCode())) * 31) + (this.n13x15 == null ? 0 : this.n13x15.hashCode())) * 31) + (this.n2x1 == null ? 0 : this.n2x1.hashCode())) * 31) + (this.n9x19 != null ? this.n9x19.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Image(n16x9=" + this.n16x9 + ", n2x3=" + this.n2x3 + ", n1x1=" + this.n1x1 + ", n18x14=" + this.n18x14 + ", n40x13=" + this.n40x13 + ", n9x16=" + this.n9x16 + ", n13x15=" + this.n13x15 + ", n2x1=" + this.n2x1 + ", n9x19=" + this.n9x19 + ')';
    }

    public Image(@JsonProperty("16x9") @NotNull String n16x9, @JsonProperty("2x3") @NotNull String n2x3, @JsonProperty("1x1") @Nullable String n1x1, @JsonProperty("18x14") @Nullable Object n18x14, @JsonProperty("40x13") @Nullable Object n40x13, @JsonProperty("9x16") @Nullable Object n9x16, @JsonProperty("13x15") @Nullable Object n13x15, @JsonProperty("2x1") @Nullable String n2x1, @JsonProperty("9x19") @Nullable String n9x19) {
        this.n16x9 = n16x9;
        this.n2x3 = n2x3;
        this.n1x1 = n1x1;
        this.n18x14 = n18x14;
        this.n40x13 = n40x13;
        this.n9x16 = n9x16;
        this.n13x15 = n13x15;
        this.n2x1 = n2x1;
        this.n9x19 = n9x19;
    }

    @NotNull
    public final String getN16x9() {
        return this.n16x9;
    }

    @NotNull
    public final String getN2x3() {
        return this.n2x3;
    }

    @Nullable
    public final String getN1x1() {
        return this.n1x1;
    }

    @Nullable
    public final Object getN18x14() {
        return this.n18x14;
    }

    @Nullable
    public final Object getN40x13() {
        return this.n40x13;
    }

    @Nullable
    public final Object getN9x16() {
        return this.n9x16;
    }

    @Nullable
    public final Object getN13x15() {
        return this.n13x15;
    }

    @Nullable
    public final String getN2x1() {
        return this.n2x1;
    }

    @Nullable
    public final String getN9x19() {
        return this.n9x19;
    }
}
